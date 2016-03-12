/*
 * Copyright (c) 2015 传化科技服务有限公司(Transfar Group) All rights reserved
 */

package org.apache.mycat.advisor.common.io.img;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 *
 * 功能:验证码图片生成器
 * Version: 1.0
 * Author: DR.YangLong
 * Date: 2014/5/13
 * Time: 19:49
 * Email:410357434@163.com
 * Editor:
 */
public class ValidateImg {
    private static Logger logger= LoggerFactory.getLogger(ValidateImg.class);
    // 图片的宽度。
    private int width = 120;
    // 图片的高度。
    private int height = 35;
    // 验证码字符个数
    private int codeCount = 4;
    // 验证码干扰线数
    private int lineCount = 80;
    // 验证码
    private String code = null;
    // 验证码图片Buffer
    private BufferedImage buffImg = null;

    private char[] codeSequence = {'0','1' ,'2', '3', '4', '5', '6', '7', '8', '9'};

    // 生成随机数
    private Random random = new Random();

    public ValidateImg() {
        this.createCode();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public ValidateImg(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public ValidateImg(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        int codeX = 0;
        int fontHeight = 0;
        fontHeight = height - 8;// 字体的高度
        codeX = width / (codeCount + 1);// 每个字符的宽度

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);

        // 绘制干扰线
        for (int i = 0; i < lineCount; i++) {
            int xs = getRandomNumber(width);
            int ys = getRandomNumber(height);
            int xe = xs + getRandomNumber(width / 8);
            int ye = ys + getRandomNumber(height / 8);
            g.setColor(getRandomColor());
            g.drawLine(xs, ys, xe, ye);
        }

        StringBuffer randomCode = new StringBuffer();
        // 随机产生验证码字符
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random
                    .nextInt(codeSequence.length)]);
            // 设置字体颜色
            g.setColor(getRandomColor());
            // 设置字体位置
            g.drawString(strRand, (i + 1) * codeX,
                    getRandomNumber(height / 2) + 20);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }

    /**
     * 获取随机颜色
     */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /**
     * 获取随机数
     */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    //获取图片缓存
    public BufferedImage getBuffImg() {
        return buffImg;
    }

    //获取验证码
    public String getCode() {
        return code;
    }

    /**
     * 字体样式类
     */
    class ImgFontByte {
        public Font getFont(int fontHeight) {
            String path = ValidateImg.class.getClassLoader().getResource("").getPath()+File.separator+"fontstyle"+File.separator+"Multicolore.otf";
            try {
                File file = new File(path);
                FileInputStream ios = new FileInputStream(file);
                Font baseFont = Font.createFont(Font.TRUETYPE_FONT, ios);
                return baseFont.deriveFont(Font.PLAIN, fontHeight);
            } catch (Exception e) {
                logger.error("获取字体文件出错，使用默认字体！\n位置：com.up360.extension.validate.ImgFontByte，\n错误信息：\n"+e.getMessage()+
                "\n程序查找位置："+path);
                return new Font("Arial", Font.PLAIN, fontHeight);
            }
        }
    }
}
