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
package org.apache.mycat.advisor.common.net.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.mycat.advisor.common.lang.StringSeriesTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * package:shiroexample.common.net.http
 * functional describe:提供各种数据返回形式post，get的http请求方法
 * 基础方法为<code>String doHttp*</code>方法
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/13 10:09
 */
public class HttpService {
    protected static Logger logger = LoggerFactory.getLogger(HttpService.class);
    private static final String DEFAULT_CHARSET = "UTF-8";

    private HttpService() {
    }

    /**
     * 发起普通的Http请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式
     * @param outputJson    请求参数
     * @return 字符串
     */
    public static String doHttpRequest(String requestUrl, String requestMethod, String outputJson) {
        String result = null;
        try {
            StringBuffer buffer = new StringBuffer();
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestProperty("Accept-Charset", DEFAULT_CHARSET);
            httpUrlConn.setRequestProperty("Content-Type",
                    "application/json;charset=" + DEFAULT_CHARSET);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputJson) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                //编码，防止中文乱码
                outputStream.write(outputJson.getBytes(DEFAULT_CHARSET));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, DEFAULT_CHARSET);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            result = buffer.toString();
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (ConnectException ce) {
            logger.error("server connection timed out.", ce);
        } catch (Exception e) {
            logger.error("http request error:", e);
        } finally {
            return result;
        }
    }

    /**
     * 发起Https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式
     * @param trustManagers 证书信任管理器
     * @param outputJson    请求参数
     * @return 字符串
     */
    public static String doHttpsRequest(String requestUrl, String requestMethod, TrustManager[] trustManagers, String outputJson) {
        String result = null;
        try {
            StringBuffer buffer = new StringBuffer();
            // 创建SSLContext对象，并使用指定的信任管理器初始化
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestProperty("Accept-Charset", DEFAULT_CHARSET);
            httpUrlConn.setRequestProperty("Content-Type",
                    "application/json;charset=" + DEFAULT_CHARSET);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputJson) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                //编码，防止中文乱码
                outputStream.write(outputJson.getBytes(DEFAULT_CHARSET));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, DEFAULT_CHARSET);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            result = buffer.toString();
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (ConnectException ce) {
            logger.error("Weixin server connection timed out.", ce);
        } catch (Exception e) {
            logger.error("https request error:", e);
        } finally {
            return result;
        }
    }

    /**
     * 发起http请求获取json对象，{@link #doHttpRequest}
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputJson
     * @return
     */
    public static JSONObject doHttpRequestGetJson(String requestUrl, String requestMethod, String outputJson) {
        JSONObject object = null;
        String string = doHttpRequest(requestUrl, requestMethod, outputJson);
        if (string != null) {
            object = JSONObject.parseObject(string);
        }
        return object;
    }

    /**
     * 发起https请求获取json对象，{@link #doHttpsRequest}
     *
     * @param requestUrl
     * @param requestMethod
     * @param trustManagers
     * @param outputJson
     * @return
     */
    public static JSONObject doHttpsRequestGetJson(String requestUrl, String requestMethod, TrustManager[] trustManagers, String outputJson) {
        JSONObject object = null;
        String string = doHttpsRequest(requestUrl, requestMethod, trustManagers, outputJson);
        if (string != null) {
            object = JSONObject.parseObject(string);
        }
        return object;
    }

    /**
     * 将输入流对应的文件上传到指定的url上
     *
     * @param inputStream 文件流
     * @param fileName    文件名称
     * @param fileType    媒体类型
     * @param contentType 请求头中的标识
     * @param identity    身份标识
     * @return 返回值
     */
    public static String uploadMediaFile(String requestUrl, FileInputStream inputStream, String fileName, String fileType, String contentType, String identity) {
        String lineEnd = System.getProperty("line.separator");
        String twoHyphens = "--";
        String boundary = "*****";
        String result = null;
        try {
            //获取连接
            URL submit = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) submit.openConnection();
            //设置连接属性
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            //方式
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", DEFAULT_CHARSET);
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            //获取输出流对象，准备上传文件
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\""
                    + fileName + ";Content-Type=\"" + contentType + lineEnd);
            dos.writeBytes(lineEnd);

            byte[] buffer = new byte[8192]; // 8k
            int count = 0;
            while ((count = inputStream.read(buffer)) != -1) {
                dos.write(buffer, 0, count);
            }
            inputStream.close();  //关闭输入流对象
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            dos.flush();

            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, DEFAULT_CHARSET);
            BufferedReader br = new BufferedReader(isr);
            result = br.readLine();
            dos.close();
            is.close();
        } catch (IOException e) {
            logger.error("上传多媒体出错：", e);
        }
        return result;
    }

    /**
     * 下载多媒体文件
     *
     * @param media_id 媒体文件在微信服务器的媒体ID
     * @param identity 身份标识
     * @param filepath 文件保存路径(不包含文件名)
     * @return 文件保存路径(包含文件名)，错误时返回error
     */
    public static String downLoadMediaFile(String requestUrl, String media_id, String identity, String filepath) {
        String mediaLocalURL = "error";
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            URL downLoadURL = new URL(requestUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) downLoadURL.openConnection();
            //方式
            connection.setRequestMethod("GET");
            // 建立实际的连接
            connection.connect();
            //如果发生错误,返回的响应头是text,返回了json
            if (connection.getContentType().equalsIgnoreCase("text/plain")) {
                // 定义BufferedReader输入流来读取URL的响应
                inputStream = connection.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));
                String valueString = null;
                StringBuffer bufferRes = new StringBuffer();
                while ((valueString = read.readLine()) != null) {
                    bufferRes.append(valueString);
                }
                inputStream.close();
                String errMsg = bufferRes.toString();
                JSONObject jsonObject = JSONObject.parseObject(errMsg);
                logger.error("下载发生错误！错误信息：" + (jsonObject.getInteger("errcode")));
                mediaLocalURL = "error";
            } else {
                BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
                String ds = connection.getHeaderField("Content-disposition");
                //文件全名
                String fullName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
                //文件前缀--文件名
                String preffix = fullName.substring(0, fullName.lastIndexOf("."));
                //文件后缀
                String suffix = fullName.substring(preffix.length() + 1);
                //长度
                String length = connection.getHeaderField("Content-Length");
                //类型
                String type = connection.getHeaderField("Content-Type");
                //将文件写入本地
                byte[] buffer = new byte[8192]; // 8k
                int count = 0;
                mediaLocalURL = filepath + File.separator;
                File file = new File(mediaLocalURL);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File mediaFile = new File(mediaLocalURL, fullName);
                fileOutputStream = new FileOutputStream(mediaFile);
                dataOutputStream = new DataOutputStream(fileOutputStream);
                while ((count = bis.read(buffer)) != -1) {
                    dataOutputStream.write(buffer, 0, count);
                }
                //关闭流
                mediaLocalURL += fullName;
                bis.close();
                dataOutputStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            logger.error("下载多媒体发生错误", e);
        }
        return mediaLocalURL;
    }

    /**
     * 读取远程文件
     *
     * @param protocol 协议http、https、ftp、file、jar
     * @param host     地址
     * @param file     主机上的文件
     * @return
     */
    public static String getRemoteFile(String protocol, String host, String file) {
        String content = null;
        try {
            URL url = new URL(protocol, host, file);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            DataInputStream input = new DataInputStream(conn.getInputStream());
            byte[] buffer = new byte[8192];
            int count = input.read(buffer);
            if (count > 0) {
                byte[] strBuffer = new byte[count];
                System.arraycopy(buffer, 0, strBuffer, 0, count);
                content = new String(strBuffer, "UTF-8");
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将空格等替换掉
        return StringSeriesTools.replaceAllMatch(content, "\\s*|\t|\r|\n", "");
    }

    /**
     * 使用apache httpclient发起post请求
     *
     * @param url       目标地址
     * @param paramsMap 参数map
     * @return 响应字符串
     */
    public static String doHttpClientPost(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, DEFAULT_CHARSET));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            logger.error("发起HTTP请求失败！", e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                logger.error("关闭HTTP请求Response失败！", e);
            }
        }
        return responseText;
    }

    /**
     * 下载文件
     *
     * @param url       地址
     * @param localPath 地址
     * @param fileName  文件名称
     * @return null/本地文件名，不带路径
     */
    public static String downloadFile(String url, String localPath, String fileName) {
        int bufferSize = 1024 * 10;
        String file = null;
        if (!localPath.endsWith(File.separator)) {
            localPath += File.separator;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);
            String fileType = "dat";
            Header header = response.getLastHeader("Content-Type");
            if (header != null) {
                String headerValue = header.getValue();
                fileType = headerValue.substring(headerValue.indexOf("/") + 1, headerValue.length());
            }
            HttpEntity entity = response.getEntity();
            long length = entity.getContentLength();
            if (length <= 0) {
                logger.warn("要下载的文件不存在！");
                return file;
            }
            inputStream = entity.getContent();
            file = fileName + "." + fileType;
            File outFile = new File(localPath);
            if (!outFile.exists()) {
                outFile.mkdirs();
            }
            localPath += file;
            outFile = new File(localPath);
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
            return file;
        } catch (IOException e) {
            logger.error("下载文件失败！", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("关闭输入出错！", e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error("关闭输出流出错！", e);
                }
            }
        }
        return file;
    }

    /**
     * 扩充微博 添加header信息
     *
     * @param requestUrl
     * @param requestMethod
     * @param WithTokenHeader
     * @param token
     * @return
     */
    public static String doHttpRequest(String requestUrl, String requestMethod, Boolean WithTokenHeader, String token) {
        String result = null;
        InetAddress ipaddr;
        int responseCode = -1;
        try {
            ipaddr = InetAddress.getLocalHost();
            StringBuffer buffer = new StringBuffer();
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestProperty("Accept-Charset", DEFAULT_CHARSET);
            httpUrlConn.setRequestProperty("Content-Type", "application/json;charset=" + DEFAULT_CHARSET);
            if (WithTokenHeader) {
                if (token == null) {
                    throw new IllegalStateException("Oauth2 token is not set!");
                }
                httpUrlConn.setRequestProperty("Authorization", "OAuth2 " + token);
                httpUrlConn.setRequestProperty("API-RemoteIP", ipaddr.getHostAddress());
            }
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

//            // 当有数据需要提交时
//            if (null != outputJson) {
//                OutputStream outputStream = httpUrlConn.getOutputStream();
//                //编码，防止中文乱码
//                outputStream.write(outputJson.getBytes(DEFAULT_CHARSET));
//                outputStream.close();
//            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, DEFAULT_CHARSET);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            result = buffer.toString();
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (ConnectException ce) {
            logger.error("server connection timed out.", ce);
        } catch (Exception e) {
            logger.error("http request error:", e);
        } finally {
            return result;
        }
    }

    /**
     * 根据URL获取资源InputStream
     *
     * @param url
     * @return
     */
    public static InputStream getImageStreamByURL(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            return conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        String name = doHttpRequest("https://api.weibo.com/2/users/show.json?uid=1666794760", "GET", true, "2.0099hnoBvPeOeEde5ac29f1dImRcmB");
        System.out.print(name);
    }
}
