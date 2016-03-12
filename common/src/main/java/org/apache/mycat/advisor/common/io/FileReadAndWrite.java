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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * package:shiroexample.common.io
 * functional describe:文件读写工具类
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/13 20:15
 */
public class FileReadAndWrite {
    private static final Logger logger = LoggerFactory.getLogger(FileReadAndWrite.class);

    /**
     * @throws IOException
     * @description 将字符串写到文件,文件目录必须存在
     */
    public static int writeStringToFile(String path, String content, String charset) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter writer = null;
        try {
            if (null != charset) {
                writer = new OutputStreamWriter(fos, charset);
            } else {
                writer = new OutputStreamWriter(fos, "UTF-8");// 默认UTF-8
            }
            writer.write(content);
        } finally {
            if (null != writer) {
                writer.flush();
                writer.close();
            }
        }
        return 1;// 文件写入成功
    }

    /**
     * 从输入流读取文件并写入本地
     *
     * @param inputStream 输入流
     * @param savePath    保存文件的本地地址
     * @param fileName    文件名
     * @return
     */
    public static boolean readAndWrite(InputStream inputStream, String savePath, String fileName) {
        if (!savePath.endsWith(File.separator)) {
            savePath += File.separator;
        }
        String fullFileName=savePath+fileName;
        FileOutputStream outputStream = null;
        try {
            File saveFile=new File(savePath);
            if(!saveFile.exists()){
                saveFile.mkdirs();
            }
            saveFile=new File(fullFileName);
            if(!saveFile.exists()){
                saveFile.createNewFile();
            }
            outputStream = new FileOutputStream(saveFile);
            byte[] temp = new byte[1024 * 10];
            int curRedLength;
            while ((curRedLength = inputStream.read(temp)) > 0) {
                outputStream.write(temp, 0, curRedLength);
            }
            return true;
        } catch (IOException e) {
            logger.error("保存文件到本地出错！",e);
            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error("无法关闭输出流！",e);
                }
            }
        }
    }

    public static void main(String[] args){
        try {
            FileReadAndWrite.writeStringToFile("d:\\f\\a.txt","dfdfdfdfdf","utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}