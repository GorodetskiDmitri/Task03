package by.epam.task03.service;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.task03.entity.Dish;
import by.epam.task03.entity.Menu;
import by.epam.task03.entity.MenuTagName;
import by.epam.task03.entity.Section;

public class StAXHandler {
	private Menu menu;
	private Section section;
	private Dish dish;
	private StringBuilder text;
	
	public Menu parse(XMLStreamReader reader) throws XMLStreamException {
		while (reader.hasNext()) {
			switch (reader.next()) {
			
			case XMLStreamConstants.START_ELEMENT:
				MenuTagName tagName = MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace('-', '_'));
				switch (tagName) {
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
				break;
			
			case XMLStreamConstants.CHARACTERS:
				text = new StringBuilder();
				text.append(reader.getText().trim());
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				MenuTagName tagNameEnd = MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace('-', '_'));
				switch(tagNameEnd) {
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
				break;
				
			}
		}
		return menu;
	}

}
