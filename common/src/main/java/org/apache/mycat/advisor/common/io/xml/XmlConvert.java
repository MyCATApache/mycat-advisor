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
package org.apache.mycat.advisor.common.io.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * package:shiroexample.common.io.xml
 * functional describe:XML与其他形式互转
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/13 18:47
 */
public class XmlConvert {
    private final static Logger logger = LoggerFactory.getLogger(XmlConvert.class);

    /**
     * 由String转换为XML对象{@link org.dom4j.Document}
     *
     * @param xmlStr xml形式的字符串
     * @return NULL/Document
     */
    public static Document str2Xml(final String xmlStr) {
        Document document = null;
        if (xmlStr != null && !"".equals(xmlStr)) {
            try {
                document = DocumentHelper.parseText(xmlStr);
            } catch (DocumentException e) {
                logger.error("由String转换为XML出错！", e);
            }
        }
        return document;
    }

    /**
     * 将xml(Document)转换为String形式
     * @param xml Document
     * @return NULL/String
     */
    public static String xml2Str(final Document xml) {
        String xmlStr = null;
        if (xml != null) {
            xmlStr = xml.asXML();
        }
        return xmlStr;
    }
}
