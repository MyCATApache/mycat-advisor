/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.io;

import org.apache.mycat.advisor.common.datetime.DateTimeUtils;
import org.apache.mycat.advisor.common.lang.StringSeriesTools;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传
 *
 */
public class FileUpload {

	public static String upload(MultipartFile multipartFile, String path) {
		String originalFileName = multipartFile.getOriginalFilename();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			String newFileName = getNewFileName(originalFileName);
			String realPath = file + File.separator + newFileName;
			FileOutputStream fileOutputStream = new FileOutputStream(realPath);
			fileOutputStream.write(multipartFile.getBytes());
			fileOutputStream.flush();
			fileOutputStream.close();
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean upload(String content, String path, String fileName) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			FileReadAndWrite.writeStringToFile(path + File.separator + fileName, content, "UTF-8");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String getNewFileName(String sourceName) {
		String suffix = sourceName.substring(sourceName.lastIndexOf("."), sourceName.length());
		String newFileName = System.currentTimeMillis() + "_" + StringSeriesTools.getNumber6FromRandom() + suffix;
		return newFileName;
	}

	public static String getTimePath() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String timePath = format.format(new Date()).replaceAll("-", File.separator);
		return timePath;
	}

	public static String renameUploadExercisePicFile(String fileName) {
		// 转换成这样的格式：@2012_01_31@1_1327978856.jpeg
		String dateString = DateTimeUtils.format(DateTimeUtils.getToday(), "yyyy_MM_dd");
		String randomString = String.valueOf(Math.round(Math.random() * 1000));
		String timestampString = String.valueOf(System.nanoTime());
		StringBuilder sb = new StringBuilder();
		sb.append("@");
		sb.append(dateString);
		sb.append("@");
		sb.append(randomString);
		sb.append("_");
		sb.append(timestampString);
		sb.append(".");
		sb.append(fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()));
		return sb.toString();
	}

}
