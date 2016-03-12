/*
        Copyright  RongYang

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
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.*;
import org.dom4j.io.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * package:com.transfar.greentech.common.io.xml
 * functional describe:XML抽象Dao
 *
 * @author RongYang
 * @version 1.0
 */
public abstract class XMLEditor {
    protected static final Log log = LogFactory.getLog(XMLEditor.class);
    public static final String DAFAULT_CHARSET = "UTF-8";
    private SAXModifier saxModifier;
    private SAXReader saxReader;

    protected XMLEditor() {
        this.saxModifier = new SAXModifier();
        this.saxReader = new SAXReader();
        this.saxReader.setEntityResolver(new IgnoreDTDEntityResolver());
    }

    public abstract XMLEditor addElements(String xPath, Map<String, String> elements);

    public abstract XMLEditor addElements(String xPath, List<Element> elements);

    public abstract XMLEditor addElement(String xPath, String elementName, String content);

    public abstract XMLEditor addElement(String xPath, Element element);

    public abstract XMLEditor addElement(String xPath, String elementName, String content, Map<String, String> attributes);

    public abstract XMLEditor removeElementByPath(String xPath);

    public abstract XMLEditor modifyElementContent(String xPath, String content, boolean overwriteAble);

    public abstract XMLEditor modifyElementName(String xPath, String elementName);

    public abstract XMLEditor addAttributes(String xPath, Map<String, String> attributes);

    public abstract XMLEditor addAttribute(String xPath, String attributeName, String attributeValue);

    public abstract XMLEditor removeAttribute(String xPath, String attributeName);

    public abstract XMLEditor removeAttributes(String xPath, Set<String> attributeNames);

    public abstract XMLEditor modifyeAttributeContent(String xPath, String content, String attributeName, boolean overwriteAble);

    public abstract XMLEditor replaceAttributeContent(String xPath, String content, String replaceContent, String attributeName);

    public abstract XMLEditor modifyeAttributesContent(String xPath, Map<String, String> attributes, boolean overwriteAble);

    public abstract void reNameElement(Element rootElement, String xpath, String newName);

    protected void addModifier(String path, ElementModifier modifier) {
        this.saxModifier.addModifier(path, modifier);

    }

    /**
     * 重置所有修改内容
     */
    public void reset() {
        this.saxModifier.resetModifiers();
    }

    /**
     * @param xpath 重置xpath的所有修改
     */
    public void reset(String xpath) {
        this.saxModifier.removeModifier(xpath);
    }

    // 产生修改的结果
    public Document modify(File source) throws DocumentException {
        return this.saxModifier.modify(source);

    }

    public Document modify(InputStream source) throws DocumentException {
        return this.saxModifier.modify(source);

    }

    public Document modify(Reader source) throws DocumentException {
        return this.saxModifier.modify(source);

    }

    public Document modify(URL source) throws DocumentException {
        return this.saxModifier.modify(source);

    }

    public Document modify(String source) throws DocumentException {
        return this.saxModifier.modify(source);

    }

    /**
     * @param rootElement
     * @param nodeName
     * @return 根据节点名称查找节点
     */

    public List<Element> seachByNodeName(Element rootElement, String nodeName) {
        StringBuffer xPathBuff = new StringBuffer();
        xPathBuff.append("//");
        xPathBuff.append(nodeName);
        List<Element> result = rootElement.selectNodes(xPathBuff.toString());
        return result;
    }

    public List searchNodeList(Element root, String xpath) {
        return root.selectNodes(xpath);
    }

    public Map<String, String> seachElementValueByNodeName(Document documentt, String... nodeNames) {
        Map<String, String> resultMap = new HashMap<String, String>();
        for (String nodeName : nodeNames) {
            StringBuffer xPathBuff = new StringBuffer();
            xPathBuff.append("//");
            xPathBuff.append(nodeName);
            List<Element> resultList = documentt.selectNodes(xPathBuff.toString());
            resultMap.put(nodeName, "");
            if (resultList.size() > 0) {
                Element valueElement = resultList.get(0);
                resultMap.put(nodeName, valueElement.getText());
            }
        }
        return resultMap;
    }

    /**
     * 保存修改结果
     *
     * @param inputFilePath  原xml文件
     * @param outPutFilePath 修改后文件
     * @return
     * @throws org.dom4j.DocumentException
     */
    public boolean save(String inputFilePath, String outPutFilePath) {
        Document document = null;
        try {
            document = modify(inputFilePath);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return save(outPutFilePath, document);

    }


    public boolean save(InputStream in, String outPutFilePath) {
        Document document = null;
        try {
            document = modify(in);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return save(outPutFilePath, document);

    }

    public boolean save(File outPutFile, Element rootElement) {
        return save(outPutFile, rootElement,true);
    }
    public boolean save(File outPutFile, Element rootElement,boolean lineAble) {
        final Document document = DocumentFactory.getInstance().createDocument(rootElement.createCopy());
        return save(outPutFile, document,lineAble);
    }

    public boolean save(File inputFile, File outPutFil) throws DocumentException {
        final Document document = modify(inputFile);
        return save(outPutFil, document);

    }

    /**
     * @param sourceFilePath
     * @param document
     * @return 保存xml文件
     */
    public boolean save(String sourceFilePath, Document document) {
        return save(new File(sourceFilePath), document);

    }

    public boolean save(OutputStream os, Document document) {
        boolean flag = true;
        XMLWriter writer = null;
        OutputStreamWriter outputStream = null;
        try {
            outputStream = new OutputStreamWriter(os, DAFAULT_CHARSET);
            writer = new XMLWriter(outputStream);
            writer.write(document);
            writer.flush();
        } catch (Exception ex) {
            log.error("保存xml文件出错", ex);
            flag = false;
            throw new RuntimeException(ex);

        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                log.error("保存xml文件时无法关闭:", e);

            }
        }
        return flag;
    }

    public boolean save(File outPutFile, Document document) {
        return save(outPutFile,document,true);
    }

    public boolean save(File outPutFile, Document document,boolean  lineAble) {
        boolean flag = true;
        XMLWriter writer = null;
        OutputStreamWriter outputStream = null;
        try {
            outputStream = new OutputStreamWriter(
                    new FileOutputStream(outPutFile), DAFAULT_CHARSET);
            final OutputFormat format = OutputFormat.createCompactFormat();//紧凑型格式
            format.setNewlines(lineAble);
            writer = new XMLWriter(outputStream, format);
            writer.write(document);
            writer.flush();
            outputStream.close();
            writer.close();
        } catch (Exception ex) {
            log.error("保存xml文件出错", ex);
            flag = false;
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                log.error("保存xml文件时无法关闭:", e);

            }
        }
        return flag;
    }

    public static Document todocument(String text) throws DocumentException {
        Document document = DocumentHelper.parseText(text);
        return document;

    }

    /**
     * @param xmlFilePath 文件路径
     * @return
     * @throws org.dom4j.DocumentException
     */
    public Element readRootElement(String xmlFilePath) throws DocumentException {
        final Document document = saxReader.read(xmlFilePath);
        return document.getRootElement();

    }

    /**
     * @param xmlFile XML文件对象
     * @return
     * @throws org.dom4j.DocumentException
     */

    public Element readRootElement(File xmlFile) throws DocumentException {
        final Document document = saxReader.read(xmlFile);
        return document.getRootElement();

    }

    public Document read(String xmlFilePath) throws DocumentException {
        final Document document = saxReader.read(xmlFilePath);
        return document;

    }

    public Document read(File xmlFile) throws DocumentException {
        final Document document = saxReader.read(xmlFile);
        return document;

    }

    public Document read(InputStream in) throws DocumentException {
        final Document document = saxReader.read(in);
        return document;

    }


    public void overlookDTD(InputStream inputStream, OutputStream outputStream) throws DocumentException {
        try {
            Document document = read(inputStream);
            writeDocument(outputStream, document.getRootElement());
        } catch (DocumentException e) {
            throw new DocumentException(e);
        } finally {
            if(inputStream!=null){
                IOUtils.closeQuietly(inputStream);
            }
        }
    }

    private void writeDocument(final OutputStream out, Element rootElement) {
        final Document document = DocumentFactory.getInstance().createDocument(rootElement.createCopy());
        writeDocument(out, document);

    }

    private void writeDocument(final OutputStream out, Document document) {
        XMLWriter xmlWriter = null;
        try {
            xmlWriter = new XMLWriter(out);
            xmlWriter.write(document);
            xmlWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

    public static int indexOf(Element rootElement, Node child) {
        int index = -1;
        for (int i = 0; i < rootElement.nodeCount(); i++) {
            if (rootElement.node(i).equals(child)) {
                index = i;
            }
        }
        return index;

    }
    public void insertElement(final Element parent,
                              final Node child, int index) {
        final List childs = new ArrayList();
        for (int i = 0; i < parent.nodeCount(); i++) {
            childs.add(parent.node(i));
        }
        childs.add(index, child);
        parent.setContent(childs);
    }

    class IgnoreDTDEntityResolver implements EntityResolver {
        @Override
        public InputSource resolveEntity(String publicId, String systemId)
                throws SAXException, IOException {
            return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
        }
    }
}
