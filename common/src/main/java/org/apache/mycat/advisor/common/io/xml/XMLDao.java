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

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.ElementModifier;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * package:com.transfar.greentech.common.io.xml
 * functional describe:XML操作Dao
 *
 * @author RongYang
 * @version 1.0
 */
public class XMLDao extends XMLEditor {
    private static XMLDao dao;

    public XMLDao() {
        super();
    }

//    private XMLDao() {
//        super();
//    }

    //创建实例
    public static XMLDao getInstance() {
        if (dao == null) {
            synchronized (XMLDao.class) {
                if (dao == null) {
                    dao = new XMLDao();
                }
            }
        }
        dao.reset();//重置
        return dao;
    }


    /**
     * @param xPath
     * @param elements key值为节点名称,value为节点值
     *                 添加多个子节点到xpath下
     */
    @Override
    public XMLDao addElements(final String xPath, final Map<String, String> elements) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                final Set<String> keySet = elements.keySet();
                for (final String elementName : keySet) {
                    final String value = elements.get(elementName);
                    Element childElement = element.addElement(elementName);
                    childElement.setText(value);
                }

                return element;
            }
        });
        return this;


    }

    public XMLDao addElements(final String xPath, final List<Element> elements) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                for (final Element childElement : elements) {
                    element.add(childElement);
                }

                return element;
            }
        });
        return this;
    }

    @Override
    public XMLDao addElement(final String xPath, final Element subElement) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                element.add(subElement);
                return element;
            }
        });
        return this;

    }

    /**
     * @param xPath       父节点路径
     * @param elementName 节点名称
     * @param content     节点值
     *                    添加子节点到xpath下
     */

    @Override
    public XMLDao addElement(final String xPath,
                             final String elementName, final String content) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                Element childElement = element.addElement(elementName);
                childElement.setText(content);
                return element;
            }
        });
        return this;

    }

    @Override
    public XMLEditor addElement(final String xPath, final String elementName,
                                final String content, final Map<String, String> attributes) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                Element childElement = element.addElement(elementName);
                childElement.setText(content);
                final Set<String> keySet = attributes.keySet();
                for (final String attributeName : keySet) {
                    final String value = attributes.get(attributeName);
                    childElement.addAttribute(attributeName, value);
                }
                return element;
            }
        });

        return this;
    }

    /**
     * @param parentXPath 需要添加节点的父节点xpath
     *                    在某节点下删除子节点
     */

    @Override
    public XMLEditor removeElementByPath(String parentXPath) {
        super.addModifier(parentXPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                element.detach();
                return null;
            }
        });
        return this;
    }

    /**
     * @param xPath         父节点路径
     * @param content       节点内容
     * @param overwriteAble 是否替换原内容
     *                      修改节点值
     */
    @Override
    public XMLEditor modifyElementContent(String xPath,
                                          final String content, final boolean overwriteAble) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                StringBuffer contentText = new StringBuffer();
                if (overwriteAble) {
                    contentText.append(content);
                } else {
                    contentText.append(element.getText());
                    contentText.append(content);
                }
                element.setText(contentText.toString());
                return element;
            }
        });
        return this;
    }

    @Override
    public XMLEditor modifyElementName(final String xPath, final String elementName) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                element.setName(elementName);
                return element;
            }
        });
        return this;
    }

    /**
     * @param xPath      父节点路径
     * @param attributes key 为属性名称 value为属性值
     */
    @Override
    public XMLEditor addAttributes(final String xPath, final Map<String, String> attributes) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                final Set<String> keySet = attributes.keySet();
                for (final String attributeName : keySet) {
                    final String value = attributes.get(attributeName);
                    element.addAttribute(attributeName, value);
                }

                return element;
            }
        });
        return this;

    }

    /**
     * @param xPath
     * @param attributeName  属性名称
     * @param attributeValue 属性值
     */
    @Override
    public XMLEditor addAttribute(String xPath, final String attributeName,
                                  final String attributeValue) {

        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                element.addAttribute(attributeName, attributeValue);
                return element;
            }
        });
        return this;
    }

    /**
     * @param xPath
     * @param attributeName 根据属性名称移除所在xpath节点的属性
     */
    @Override
    public XMLEditor removeAttribute(String xPath, final String attributeName) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                element.remove(element.attribute(attributeName));
                return element;
            }
        });
        return this;
    }

    /**
     * @param xPath
     * @param attributeNames key 为属性名称 value为属性值
     */
    public XMLEditor removeAttributes(String xPath, final Set<String> attributeNames) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                for (String attributeName : attributeNames) {
                    element.remove(element.attribute(attributeName));
                }
                return element;
            }
        });
        return this;
    }

    /**
     * @param xPath
     * @param content
     * @param attributeName
     * @param overwriteAble 修改属性内容
     */
    @Override
    public XMLEditor modifyeAttributeContent(String xPath,
                                             final String content,
                                             final String attributeName,
                                             final boolean overwriteAble) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                Attribute attribute = element.attribute(attributeName);
                StringBuffer contentText = new StringBuffer();
                if (overwriteAble) {
                    contentText.append(content);
                } else {
                    contentText.append(attribute.getText());
                    contentText.append(content);
                }
                attribute.setText(contentText.toString());
                return element;
            }
        });
        return this;
    }

    public XMLEditor replaceAttributeContent(final String xPath, final String content,
                                             final String replaceContent, final String attributeName) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                Attribute attribute = element.attribute(attributeName);
                String tempContent = attribute.getText();
                tempContent = tempContent.replace(content, replaceContent);
                attribute.setText(tempContent);
                return element;
            }
        });
        return this;

    }

    /**
     * @param xPath
     * @param attributes    key 为属性名称 value为属性值
     * @param overwriteAble
     */

    public XMLEditor modifyeAttributesContent(String xPath,
                                              final Map<String, String> attributes,
                                              final boolean overwriteAble) {
        super.addModifier(xPath, new ElementModifier() {
            @Override
            public Element modifyElement(Element element) throws Exception {
                Set<String> attributeNames = attributes.keySet();
                for (String attributeName : attributeNames) {
                    final Attribute attribute = element.attribute(attributeName);
                    final String content = attributes.get(attributeName);
                    StringBuffer contentText = new StringBuffer();
                    if (overwriteAble) {
                        contentText.append(content);
                    } else {
                        contentText.append(attribute.getText());
                        contentText.append(content);
                    }
                    attribute.setText(contentText.toString());
                }
                return element;
            }
        });
        return this;
    }

    @Override
    public void reNameElement(Element rootElement, String xpath, String newName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * 解析xml  attribute
     *
     * @return
     * @throws org.dom4j.DocumentException
     */
    public Set<String> parserAttribute(Element rootElement, String xpath
            , String attributeName) throws DocumentException {
        Set<String> attributeSet = new HashSet<String>();
        List elements = rootElement.selectNodes(xpath);
        for (Object attributeObject : elements) {
            if (attributeObject instanceof Element) {
                Element element = (Element) attributeObject;
                String attributeText = element.attribute(attributeName).getText();
                if (StringUtils.isNotEmpty(attributeText)) {
                    attributeSet.add(attributeText);
                }
            }
        }
        return attributeSet;

    }

    /**
     * 解析xml  attribute
     *
     * @return
     * @throws org.dom4j.DocumentException
     */
    public Set<String> parserAttribute(Document document, String xpath
            , String attributeName) throws DocumentException {
        return parserAttribute(document.getRootElement(), xpath, attributeName);

    }


    /**
     * 解析xml  attribute
     *
     * @return
     * @throws org.dom4j.DocumentException
     */
    public Set<String> parserElement(Document rootElement, String xpath) throws DocumentException {
        Set<String> elementValueSet = new HashSet<String>();
        List elements = rootElement.selectNodes(xpath);
        for (Object elementObject : elements) {
            if (elementObject instanceof Element) {
                Element element = (Element) elementObject;
                String elementValue = element.getText();
                if (StringUtils.isNotEmpty(elementValue)) {
                    elementValueSet.add(elementValue);
                }
            }
        }
        return elementValueSet;

    }


//    public static void main(String[] args) throws DocumentException {
////        Thread thread = new Thread(new ReadJVMRAM());
////        thread.start();
////        final String outPutPath = "E:\\xml\\CDA-A330_AMM_80_13_41_04_400_804_EN80134140080400-BIG.xml";
////        final String inputPath = "E:\\xml\\CDA-A330_AMM_80_13_41_04_400_804_EN80134140080400.xml";
////        final String modifPath = "E:\\xml\\CDA-A330_AMM_80_13_41_04_400_804_EN80134140080400-BIG-NEW.xml";
////        long start = System.currentTimeMillis();
////        XMLDao dao = XMLDao.getInstance();
////        Document document = dao.read(inputPath);
////        Element element = document.getRootElement();
////        for (int i = 0; i <10*10*1000; i++) {
////            element.addElement("element").setText(System.currentTimeMillis() + "");
////        }
////        dao.save(outPutPath, document);
////
////        dao.modifyElementName("/TASK/element", "newElement");
////        dao.save(outPutPath, modifPath);
//        Document newDome=dao.read(outPutPath);
//        List<Element> elements=newDome.selectNodes("//TITLE");
//        System.out.println("find element="+elements.size());
//        Element titleElement=elements.get(0);
//        titleElement.setName("TITLEC");
//         System.out.println(elements.get(0).asXML());
//        XMLDao.getInstance().save(new File(modifPath),newDome);
//        long end = System.currentTimeMillis() - start;
//        System.out.println("耗时:"+(end / 1000)+" 秒");
//    }
}
