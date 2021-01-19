package pageUIs;

public class NewCustomerPageUI {
	
	public static final String CUSTOMER_TEXT_BOX ="//input[@name='name']"; 
	public static final String GENDER_RADIOBUTTON ="//input[@value='f']"; 
	public static final String CALENDAR ="//input[@type='date']"; 
	public static final String ADDRESS_TEXT_BOX ="//td[text()='Address']//following-sibling::td/textarea"; 
	public static final String CITY_TEXT_BOX ="//td[text()='City']"; 
	public static final String SUBMIT_BUTTON ="//input[@type='submit']"; 
	public static final String NAME_CANOT_BE_EMPTY_ERROR_MESSAGE ="//label[text()='Customer name must not be blank']"; 
	public static final String NUMBERS_ARE_NOT_ALLOWED_ERROR_MESSAGE ="//label[text()='Numbers are not allowed']"; 
	public static final String SPECIAL_CHARACTER_ARE_NOT_ALLOWED_ERROR_MESSAGE ="//label[text()='Special characters are not allowed']"; 
	public static final String BLANK_FIRST_CHARACTER_AT_CUSTOMER_NAME_ARE_NOT_ALLOWED_ERROR_MESSAGE ="//label[text()='First character can not have space']"; 
	public static final String BLANK_FIRST_CHARACTER_AT_ADRESS_ARE_NOT_ALLOWED_ERROR_MESSAGE ="//td[text()='Address']//following-sibling::td//label"; 
	public static final String ADRESS_CAN_NOT_BE_EMPTY_ERROR_MESSAGE ="//label[text()='Address Field must not be blank']"; 

	//Dynamic locator
	public static final String DYNAMIC_FIELD_LABLE ="//td[text()='%s']";
	public static final String DYNAMIC_TEXT_BOX_AT_ADD_NEW_CUSTOMER ="//input[@name='%s']"; 
	
}
