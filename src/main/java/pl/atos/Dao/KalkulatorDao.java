package pl.atos.Dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pl.atos.model.Kalkulator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class KalkulatorDao {

    private Kalkulator kalkulator;

    public List<Kalkulator> getValues() {
        List<Kalkulator> kalkulatorList = new ArrayList<>();
        try {
            File inputFile = new File("C:/Users/Developer/Documents/PROJEKTY/Kalkulator_Walut/src/currency.xml");
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
                    String currency = element.getAttribute("currency");
                    System.out.println("Currency : " + currency);
                    String rate = element.getAttribute("rate");
                    float rates = Float.parseFloat(rate);
                    System.out.println("Rate : " + rates);

                    kalkulatorList.add(new Kalkulator(currency, rates));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return kalkulatorList;
    }

}
