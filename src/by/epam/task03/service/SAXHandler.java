package by.epam.task03.service;

import by.epam.task03.entity.Dish;
import by.epam.task03.entity.Menu;
import by.epam.task03.entity.MenuTagName;
import by.epam.task03.entity.Section;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	
	private Menu menu;
	private Section section;
	private Dish dish;
	private StringBuilder text;
	
	public Menu getMenu() {
		return menu;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("SAX-parser: Parsing started");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace('-', '_'));
		switch(tagName) {
		case MENU:
			menu = new Menu();
			break;
		case SECTION:
			section = new Section();
			break;
		case DISH:
			dish = new Dish();
			break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text = new StringBuilder();
		text.append(ch, start, length);
	}
	
	@Override 
	public void endElement(String uri, String localName, String qName) throws SAXException {
		MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace('-', '_'));
		switch(tagName) {
		case SECTION:
			menu.addSection(section);
			break;
		case DISH:
			section.addDish(dish);
			break;
		case SECTION_NAME:
			section.setName(text.toString());
			break;
		case DISH_PHOTO:
			dish.setPhoto(text.toString());
			break;
		case DISH_NAME:
			dish.setName(text.toString());
			break;
		case DISH_DESCRIPTION:
			dish.setDescription(text.toString());
			break;
		case DISH_PORTION:
			dish.setPortion(text.toString());
			break;
		case DISH_PRICE:
			dish.setPrice(Integer.parseInt(text.toString()));
			break;
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("SAX-parser: Parsing ended");
	}

}
