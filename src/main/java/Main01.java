import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main01 {
    public static void main(String[] args) {

        try {
            File inputFile = new File("currency.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
            System.out.println("Root element : " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("Cube");
            System.out.println("-------------------------------------");

            for (int i = 2; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                System.out.println("\nCurrent element : " + node.getNodeName());

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
//                    System.out.println("Cube no : " + element.getElementsByTagName("Cube").item(0));
//                    System.out.println("Currency : " + element.getAttribute("currency"));
//                    System.out.println("Rate : " + element.getAttribute("rate"));
                    String currency = element.getAttribute("currency");
                    System.out.println("Currency : " + currency);
                    String rate = element.getAttribute("rate");
                    float rates = Float.parseFloat(rate);
                    System.out.println("Rate : " + rates);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
