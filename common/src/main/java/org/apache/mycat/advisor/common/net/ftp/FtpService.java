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

package org.apache.mycat.advisor.common.net.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * package: com.transfar.greentech.common.net.ftp </br>
 * functional describe:Ftp服务，ftp文件上传下载
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2015/7/2 20:19
 */
public class FtpService {
    private static final Logger logger = LoggerFactory.getLogger(FtpService.class);
    //Linux下默认ftp端口
    private static final int DEFAULT_PORT = 21;
    //ftp账号
    private String userName;
    //ftp密码
    private String password;
    //ftp端口
    private int port = DEFAULT_PORT;
    //ftp服务器地址
    private String url;

    /**
     * 上传文件
     *
     * @param fileName   文件名
     * @param path       ftp保存路径
     * @param fileStream 文件输入流
     * @return true/false 成功失败
     */
    public boolean uploadFile(String fileName, String path, InputStream fileStream) {
        boolean success = false;
        FTPClient ftpClient = new FTPClient();
        try {
            int replyCode;
            ftpClient.connect(url, port);
            ftpClient.login(userName, password);
            replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                return false;
            }
            ftpClient.changeWorkingDirectory(path);
            ftpClient.storeFile(fileName, fileStream);
            fileStream.close();
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            logger.error("ftp上传文件出错！", e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    logger.error("关闭ftp链接出错！", e);
                }
            }
        }
        return success;
    }

    /**
     * 下载文件
     *
     * @param remotePath ftp路径
     * @param fileName   要下载的文件名称
     * @param localPath  本地路径，不带文件名
     * @return true/false 成功失败
     */
    public boolean downloadFile(String remotePath, String fileName, String localPath) {
        boolean success = false;
        FTPClient ftpClient = new FTPClient();
        try {
            int replyCode;
            ftpClient.connect(url, port);
            ftpClient.login(userName, password);
            replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                return false;
            }
            ftpClient.changeWorkingDirectory(remotePath);
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                if (file.getName().equals(fileName)) {
                    File localFile = new File(localPath + File.separator + file.getName());
                    OutputStream outputStream = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), outputStream);
                    outputStream.close();
                }
            }
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            logger.error("ftp下载文件出错！", e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    logger.error("关闭ftp链接出错！", e);
                }
            }
        }
        return success;
    }
}
