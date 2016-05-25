package by.epam.task03.main;

import by.epam.task03.entity.Dish;
import by.epam.task03.entity.Menu;
import by.epam.task03.entity.Section;

import by.epam.task03.service.SAXHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class MainForSAX {

    private static final String xmlFileURI = "xml\\menu.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        XMLReader reader = XMLReaderFactory.createXMLReader();
        SAXHandler saxHandler = new SAXHandler();
        reader.setContentHandler(saxHandler);
        
        try {
        	reader.parse(new InputSource(xmlFileURI));
        } catch (Exception e) {
        	System.out.println("unknown resource");
        }
        
        Menu menu = saxHandler.getMenu();
        
        System.out.println("МЕНЮ:\n");
        for (Section section : menu.getSections()) {
            System.out.println(section.getName());
            for (Dish dish : section.getDishes()) {
                System.out.println(
                		"\tНазвание: " + dish.getName() +
                		"\n\tОписание: " + (dish.getDescription() != null ? dish.getDescription() : "отсутствует") +
                		"\n\tПорция: " + dish.getPortion() + 
                		"\n\tЦена: " + (dish.getPrice() != 0 ? dish.getPrice() : "не указана") +
                		"\n\tФото: " + dish.getPhoto() +
                		"\n"); 		
            }
        }
    }
}