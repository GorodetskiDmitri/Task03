package by.epam.task03.main;

import by.epam.task03.entity.Dish;
import by.epam.task03.entity.Menu;
import by.epam.task03.entity.Section;

import by.epam.task03.service.StAXHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class MainForStAX {

    private static final String xmlFileURI = "xml\\menu.xml";

    public static void main(String[] args) throws IOException, XMLStreamException {

        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = new FileInputStream(xmlFileURI);
        XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
        
        StAXHandler staxHandler = new StAXHandler();
        
        Menu menu = staxHandler.parse(reader);
        
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