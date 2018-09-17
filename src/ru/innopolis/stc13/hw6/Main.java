package ru.innopolis.stc13.hw6;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, TransformerException, ParserConfigurationException, ClassNotFoundException, SAXException, InstantiationException, IOException {

        Cat cat = new Cat(5, "Tom", true);
        XmlSerializator.serialize(cat, "xmltext.xml");
        System.out.println(XmlSerializator.deserialize("xmltext.xml"));
    }
}
