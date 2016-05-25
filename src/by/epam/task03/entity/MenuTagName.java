package by.epam.task03.entity;

public enum MenuTagName {
	MENU, SECTION, DISH, SECTION_NAME, DISH_PHOTO, DISH_NAME, DISH_DESCRIPTION, DISH_PORTION, DISH_PRICE;
	
	public static MenuTagName getElementByTagName(String element) {
		switch(element) {
		case "menu":
			return MENU;
		case "section":
			return SECTION;
		case "dish":
			return DISH;
		case "section-name":
			return SECTION_NAME;
		case "dish-photo":
			return DISH_PHOTO;
		case "dish-name":
			return DISH_NAME;
		case "dish-description":
			return DISH_DESCRIPTION;
		case "dish-portion":
			return DISH_PORTION;
		case "dish-price":
			return DISH_PRICE;
		default:
			throw new EnumConstantNotPresentException(MenuTagName.class, element);
		}
	}
}
