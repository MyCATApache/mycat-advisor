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

import ch.qos.logback.classic.gaffer.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * 功能或描述：读写修改properties文件
 *
 * @Author: DR.YangLong
 * @Date: 14-6-27
 * @Time: 下午10:20
 * @Email: 410357434@163.com
 * @Version: 1.0
 * @Module: 修正:            日期：
 */
public class PropertiesUtils {
    private static Logger logger= LoggerFactory.getLogger(PropertiesUtils.class);
    private static final String PROPERTY_FILE = PropertiesUtils.class.getClassLoader().getResource("").getPath();

    /**
     * 读取配置文件中属性值
     * @param sourceFilename 配置文件名
     * @param key 配置文件中的key
     * @return String
     */
    public static String readData(String sourceFilename,final String key) {
        Properties props = new Properties();
        try {
            sourceFilename=getPropertyFileName(sourceFilename);
            InputStream in = new BufferedInputStream(new FileInputStream(
                    PROPERTY_FILE+sourceFilename));
            props.load(in);
            in.close();
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据键值对修改或新增
     * @param sourceFilename 配置文件名
     * @param key 键
     * @param value 值
     */
    public static synchronized void writeData(String sourceFilename,final String key, final String value) {
        Properties prop = new Properties();
        try {
            sourceFilename=getPropertyFileName(sourceFilename);
            InputStream fis = new FileInputStream(PROPERTY_FILE+sourceFilename);
            prop.load(fis);
            fis.close();//一定要在修改值之前关闭fis
            prop.setProperty(key.toUpperCase(), value);
            //放到加载key value之后，防止有的环境下将会覆盖原资源文件造成内容丢失
            OutputStream fos = new FileOutputStream(PROPERTY_FILE+sourceFilename);
            prop.store(fos, "Update " + key + "'s value");
            fos.close();
        } catch (IOException e) {
            logger.error("Update prop of the file " + PROPERTY_FILE+sourceFilename + " failure,the prop's key is "+key+
                    " the new value is "+value);
        }
    }

    /**
     * 获取classpath下的配置文件
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName){
        fileName=getPropertyFileName(fileName);
        Properties prop=null;
        InputStream inputStream=null;
        try {
            prop=new Properties();
            inputStream=PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
            prop.load(inputStream);
            inputStream.close();
            return prop;
        } catch (IOException e) {
            logger.error("加载不了配置文件："+fileName);
            return prop;
        }
    }
    private static String getPropertyFileName(final String fileName){
        String sourceFilename=fileName;
        if(!fileName.contains(".properties")){
            sourceFilename=fileName+".properties";
        }
        return sourceFilename;
    }

    public static String getProperty(Properties props, String key, String defaultValue) {
        return props.getProperty(key, defaultValue).trim();
    }

    public static int getProperty(Properties props, String key, int defaultValue) {
        try{
            return Integer.parseInt(props.getProperty(key, String.valueOf(defaultValue)).trim());
        }catch(Exception e){
            return defaultValue;
        }
    }

    public static boolean getProperty(Properties props, String key, boolean defaultValue) {
        return "true".equalsIgnoreCase(props.getProperty(key, String.valueOf(defaultValue)).trim());
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        writeData("wechat.properties","T_ACCESSTOKEN", "1123");
        System.out.println("路径："+PROPERTY_FILE+"读取TOken:"+readData("wechat","SIMPLE_BOUND_URL"));
    }
}
