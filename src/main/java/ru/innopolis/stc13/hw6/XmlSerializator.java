package ru.innopolis.stc13.hw6;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class XmlSerializator {

    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private static TransformerFactory tf = TransformerFactory.newInstance();

    static {
        factory.setNamespaceAware(false);
        factory.setValidating(false);
    }

    private XmlSerializator() {
    }

    public static void serialize(Object object, String file) throws ParserConfigurationException, IllegalAccessException, TransformerException {
        File fileToWrite = new File(file);
        if (!fileToWrite.exists() || fileToWrite.isDirectory()) {
            return;
        }
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element element = doc.createElement("class");
        doc.appendChild(element);
        Text text = doc.createTextNode(object.getClass().getName());
        element.appendChild(text);
        Element childElement;
        Text childText;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            childElement = doc.createElement(field.getName());
            childText = doc.createTextNode(field.get(object).toString());
            childElement.appendChild(childText);
            element.appendChild(childElement);
        }
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(fileToWrite);
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
    }

    public static Object deserialize(String file) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File fileToRead = new File(file);
        if (!fileToRead.exists() || fileToRead.isDirectory()) {
            return null;
        }
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileToRead);
        Element classElement = document.getDocumentElement();
        Text text = (Text) classElement.getFirstChild();
        Class clazz = Class.forName(text.getData());
        Object object = clazz.newInstance();
        NodeList nodes = classElement.getChildNodes();
        Map<String, Field> map = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName, f -> f));
        for (int i = 0; i < nodes.getLength(); i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element childElement = (Element) child;
            Field field = map.get(childElement.getTagName());
            Text childText = (Text) childElement.getFirstChild();
            field.setAccessible(true);
            String value = childText.getData();
            switch (field.getType().getSimpleName()) {
                case "int":
                    field.set(object, Integer.parseInt(value));
                    break;
                case "long":
                    field.set(object, Long.parseLong(value));
                    break;
                case "short":
                    field.set(object, Short.parseShort(value));
                    break;
                case "byte":
                    field.set(object, Byte.parseByte(value));
                    break;
                case "float":
                    field.set(object, Float.parseFloat(value));
                    break;
                case "double":
                    field.set(object, Double.parseDouble(value));
                    break;
                case "boolean":
                    field.set(object, Boolean.parseBoolean(value));
                    break;
                case "String":
                    field.set(object, value);
            }
        }
        return object;
    }
}
