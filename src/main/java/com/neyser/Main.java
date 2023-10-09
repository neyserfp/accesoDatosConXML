package com.neyser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // Referencia del archivo
        // File file = new File("./xml\\xmlData1.xml");
        File file1 = new File("src\\main\\java\\com\\neyser\\xml\\xmlData1.xml");

        // DocumentBuilderFactory y DocumentBuilder -> Genera un documento XML vacío en memoria
        DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = dbf1.newDocumentBuilder();

        // volcar el contenido del fichero xml al objeto document1
        Document document1 = db1.parse(file1);
        document1.getDocumentElement().normalize();

        // Extraer el nombre del nodo
        System.out.println("Elemento raíz: "+document1.getDocumentElement().getNodeName()+"\n");

        // Volcamos los nodos contenidos en el nodo indicado a través de (getElementByTagName)
        NodeList nodeList1 = document1.getElementsByTagName("hotel");

        // Se recorre la lista de nodos extraida
        for (int i = 0; i < nodeList1.getLength(); i++)
        {
            // Extrae el nodo actual
            Node node1 = nodeList1.item(i);

            // Se obtiene el nombre del elemento actual
            System.out.println("Elemento actual: " + node1.getNodeName());

            // Devolver un número indicando el tipo de nodo que es
            // (Si es un elemento devolverá 1 y si es un documento devolverá 9)
            if (node1.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element1 = (Element) node1;
                System.out.println("Id: "+element1.getAttribute("id"));
                System.out.println("nombre: "+element1.getAttribute("nombre"));
            }
        }

    }
}