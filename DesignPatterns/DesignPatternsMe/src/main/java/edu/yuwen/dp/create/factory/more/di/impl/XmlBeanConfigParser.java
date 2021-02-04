package edu.yuwen.dp.create.factory.more.di.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.yuwen.dp.create.factory.more.di.BeanConfigParser;
import edu.yuwen.dp.create.factory.more.di.entity.BeanDefinition;
import edu.yuwen.dp.create.factory.more.di.entity.BeanDefinition.ConstructorArg;

public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputStream);

            // 关于 xml 为什么需要 normalize 一下
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList beanList = doc.getElementsByTagName("bean");

            for (int i = 0; i < beanList.getLength(); i++) {
                Node node = beanList.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                Element element = (Element) node;
                BeanDefinition beanDefinition = new BeanDefinition(element.getAttribute("id"),
                        element.getAttribute("class"));
                if (element.getAttribute("scope").equals("singleton")) {
                    beanDefinition.setScope(BeanDefinition.Scope.SINGLETON);
                }
                if (element.getAttribute("lazy-init").equals("true")) {
                    beanDefinition.setLazyInit(true);
                }
                loadConstructorArgs(element.getElementsByTagName("constructor-arg"), beanDefinition);

                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beanDefinitions;
    }

    public void loadConstructorArgs(NodeList nodes, BeanDefinition beanDefinition) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element element = (Element) node;

            ConstructorArg constructorArg = null;
            String type = element.getAttribute("type");
            if (!type.isEmpty()) {
                // 需要对不同的参数类型做处理，这里仅支持示例中的String和int
                // 默认参数类型为String
                Class typeClass = String.class;
                Object value = element.getAttribute("value");
                if (type.equals("int")) {
                    typeClass = int.class;
                    value = new Integer(value.toString());
                }

                constructorArg = new ConstructorArg();
                constructorArg.setType(typeClass);
                constructorArg.setArg(value);
            }

            if (!element.getAttribute("ref").isEmpty()) {
                constructorArg = new ConstructorArg();
                constructorArg.setRef(true);
                constructorArg.setArg(element.getAttribute("ref"));
            }

            beanDefinition.addConstructorArg(constructorArg);
        }
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        // 实现同上，可以考虑合并
        return null;
    }
}