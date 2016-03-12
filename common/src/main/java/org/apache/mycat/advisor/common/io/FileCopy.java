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

import java.io.*;

/**
 * 文件复制
 */
public class FileCopy {

	public static void fileCopy(String sourceFileName, String targetFileName) {
		int maxBufferSize = 1024;
		File f = new File(sourceFileName);
		FileInputStream fileIn = null;
		FileOutputStream outStream = null;
		try {
			byte[] temp = new byte[maxBufferSize];
			fileIn = new FileInputStream(f);
			File targetFile = new File(targetFileName);
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			outStream = new FileOutputStream(targetFile);
			// 当前读取的字节数
			int curRedLength;
			while ((curRedLength = fileIn.read(temp)) > 0) {
				outStream.write(temp, 0, curRedLength);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
				if (fileIn != null) {
					fileIn.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
