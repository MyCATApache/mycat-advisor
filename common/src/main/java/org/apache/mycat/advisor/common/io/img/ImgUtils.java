package org.apache.mycat.advisor.common.io.img;


import org.apache.mycat.advisor.common.io.FileCopy;
import org.apache.mycat.advisor.common.io.img.gif.AnimatedGifEncoder;
import org.apache.mycat.advisor.common.io.img.gif.GifDecoder;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Iterator;

public class ImgUtils {

	public static String STRETCHING = "stretching";
	public static String FIT = "fit";

	private static String _method = "fit";
	private static boolean resetMethodFlag = true;

	public ImgUtils() {
	}

	public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
		// targetW，targetH分别表示目标长和宽

		// 若目标宽或高<=0时系数设为正无穷，表示只根据高或宽缩放
		double sx = targetW > 0 ? (double) targetW / source.getWidth() : 1f / 0;
		double sy = targetH > 0 ? (double) targetH / source.getHeight() : 1f / 0;
		if (_method.equals(FIT)) {
			// 这里想实现在targetW，targetH范围内实现等比缩放。
			if (sx > sy) {
				sx = sy;
				targetW = (int) (sx * source.getWidth());
			} else {
				sy = sx;
				targetH = (int) (sy * source.getHeight());
			}
		} else if (_method.equals(STRETCHING)) {
			// 不保持比例，拉伸
			targetW = targetW > 0 ? targetW : source.getWidth();
			targetH = targetH > 0 ? targetH : source.getHeight();
		}

		BufferedImage target = null;
		Graphics2D g = null;
		target = getNewTarget(source, targetW, targetH);
		g = target.createGraphics();
		Image scaleImage = source.getScaledInstance(targetW, targetH, Image.SCALE_SMOOTH);
		g.drawImage(scaleImage, 0, 0, targetW, targetH, null);

		g.dispose();
		return target;
	}

	private static BufferedImage getNewTarget(BufferedImage source, int targetW, int targetH) {
		int type = source.getType();
		BufferedImage target = null;
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		return target;
	}

	/**
	 * 创建缩略图
	 * 
	 * @param sourceFileName
	 * @param width
	 * @param hight
	 * @param alias
	 * @return
	 * @throws Exception
	 */
	public static String createThumbImage(String sourceFileName, int width, int hight, String alias) throws Exception {
		if (resetMethodFlag)
			_method = FIT;
		resetMethodFlag = true;
		BufferedImage srcImage;
		File file = new File(sourceFileName);
		String path = sourceFileName.substring(0, sourceFileName.lastIndexOf("/"));
		String fileName = file.getName();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String ex = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String imgType = "JPEG";
		FileInputStream is = new FileInputStream(sourceFileName);
		byte[] B = new byte[8];
		try {
			is.read(B, 0, B.length);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer type = new StringBuffer("");
		for (Byte b : B) {
			type.append(b.toString() + ",");
		}
		if ("-119,80,78,71,13,10,26,10,".equals(type.toString())) {
			imgType = "PNG";
			if (!ex.toLowerCase().equals(".png"))
				ex = ".png";
		}
		String imgAlias = alias == null ? "_s" : alias;
		String newFileName = name + imgAlias + ex;
		String saveToFileStr = path + "/" + newFileName;
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(sourceFileName);
		srcImage = ImageIO.read(fromFile);

		// 因为目的是生成缩略图 目标尺寸比原图片还大时不进行缩放操作
		double sx = width > 0 ? (double) width / srcImage.getWidth() : 1f / 0;
		double sy = hight > 0 ? (double) hight / srcImage.getHeight() : 1f / 0;
		if (Math.min(sx, sy) > 1) {
			FileCopy.fileCopy(sourceFileName, saveToFileStr);
			return newFileName;
		}

		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		if (ImageIO.write(srcImage, imgType, saveFile))
			return newFileName;
		else
			return null;

	}

	public static String createThumbImage(String sourceFileName, int width, int hight, String alias, String method)
			throws Exception {
		resetMethodFlag = false;
		_method = method;
		return createThumbImage(sourceFileName, width, hight, alias);
	}

	// 不建议使用，gif动画缩放需要逐帧处理，对于大动画会很慢
	public static boolean resizeGif(String sourceFileName, String saveToFileStr, int targetW, int targetH)
			throws Exception {
		GifDecoder decoder = new GifDecoder();
		AnimatedGifEncoder encoder = new AnimatedGifEncoder();
		if (decoder.read(sourceFileName) != GifDecoder.STATUS_OK)
			return false;
		BufferedImage source = decoder.getImage();

		// 若目标宽或高<=0时系数设为正无穷，表示只根据高或宽缩放
		double sx = targetW > 0 ? (double) targetW / source.getWidth() : 1f / 0;
		double sy = targetH > 0 ? (double) targetH / source.getHeight() : 1f / 0;

		// 这里想实现在targetW，targetH范围内实现等比缩放。
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}

		if (!encoder.start(saveToFileStr))
			return false;
		encoder.setSize(targetW, targetH);
		encoder.setRepeat(decoder.getLoopCount());
		if (decoder.isTransparency()) {
			encoder.setTransparent(decoder.getTransColor());
		}
		boolean result = true;
		for (int i = 0; i < decoder.getFrameCount(); i++) {
			if (!encoder.addFrame(resize(decoder.getFrame(i), targetW, targetH)))
				result = false;
			encoder.setDelay(decoder.getDelay(i));
		}
		encoder.finish();
		return result;
	}

	/**
	 * 图片剪切工具方法
	 * 
	 * @param srcfile
	 *            源图片
	 * @param outfile
	 *            剪切之后的图片
	 * @param formatName,
	 *            图片格式名，仅对bmp,png,jpg格式进行了测试
	 * @param x
	 *            剪切顶点 X 坐标
	 * @param y
	 *            剪切顶点 Y 坐标
	 * @param width
	 *            剪切区域宽度
	 * @param height
	 *            剪切区域高度
	 * 
	 * @throws IOException
	 */
	private static void cut(File srcfile, File outfile, String formatName, int x, int y, int width, int height)
			throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			is = new FileInputStream(srcfile);
			BufferedImage bi=cutImg(is,formatName,x,y,width,height);
			// 保存新图片
			ImageIO.write(bi, formatName, outfile);
		} finally {
			if (is != null) {
				is.close();
			}
			if (iis != null) {
				iis.close();
			}
		}
	}

	/**
	 *
	 * @param source 源文件
	 * @param formatName 格式
	 * @param x x坐标
	 * @param y y坐标
	 * @param width 宽
	 * @param height 高
	 * @return
	 */
	public static BufferedImage cutImg(InputStream source,String formatName,int x,int y,int width,int height) throws IOException{
		Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(formatName);
		ImageReader reader = it.next();
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
		Rectangle rect = new Rectangle(x, y, width, height);
		param.setSourceRegion(rect);
		BufferedImage img = reader.read(0, param);
		return img;
	}

	/**
	 *
	 * @param source 源文件
	 * @param formatName 格式
	 * @param x x坐标
	 * @param y y坐标
	 * @param width 宽
	 * @param height 高
	 * @return
	 */
	public static InputStream cut(InputStream source,String formatName,int x,int y,int width,int height) throws IOException{
		BufferedImage img=cutImg(source,formatName,x,y,width,height);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageOutputStream imageOutputStream=ImageIO.createImageOutputStream(byteArrayOutputStream);
		ImageIO.write(img,formatName,imageOutputStream);
		byte[] out=byteArrayOutputStream.toByteArray();
		byteArrayOutputStream.close();
		imageOutputStream.close();
		InputStream inputStream=new ByteArrayInputStream(out);
		return inputStream;
	}

	/**
	 * 修正图片尺寸，会将矩形的图片裁剪成长宽相等的图片
	 * 仅对bmp,png,jpg格式进行了测试，不在此范围的其它图片会以jpg格式裁剪
	 *
	 * @param sourceFileName 文件路径，需要包含格式后缀，如 file.jpg
	 * @throws IOException
	 */
	public static void rectify(String sourceFileName) throws IOException {
		File srcfile = new File(sourceFileName);
		if (!srcfile.exists()) {
			return;
		}
		String formatName = "jpg"; // 默认按照jpg格式处理
		if (sourceFileName.lastIndexOf('.') != -1) {
			String ext = sourceFileName.substring(sourceFileName.lastIndexOf('.') + 1);
			String[] exts = new String[] { "jpg", "jpeg", "bmp", "png" };
			for (String tmpExt : exts) {
				if (tmpExt.equals(ext)) {
					formatName = tmpExt;
					break;
				}
			}
		}
		File outfile = new File(sourceFileName);
		BufferedImage image = ImageIO.read(srcfile);
		int width = image.getWidth();
		int height = image.getHeight();
		int targetX = 0;
		int targetY = 0;
		int size = 0;
		if (width > height) {
			targetX = (width - height) / 2;
			size = height;
		} else {
			targetY = (height - width) / 2;
			size = width;
		}
		cut(srcfile, outfile, formatName, targetX, targetY, size, size);
	}
}