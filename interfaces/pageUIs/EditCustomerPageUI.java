package pageUIs;

public class EditCustomerPageUI {
	public static final String CUSTOMER_ID_TEXTBOX ="//input[@name='cusid']"; 
	public static final String CUSTOMER_ID_LABEL ="//td[text()='Customer ID']"; 
	public static final String EDIT_CUSTOMER_LABLE_AT_EDIT_PAGE ="//p[text()='Edit Customer']";
	
	//Dynamic locator
	public static final String DYNAMIC_CUSTOMER_ID_MESSAGE ="//label[text()='%s']"; 
	public static final String FIELD_TEXTAREA_AT_EDIT_PAGE ="//tr//td[text()='%s']/following-sibling::td/textarea[@name='%s']"; 
	public static final String FIELD_TEXTBOX_AT_EDIT_PAGE ="//tr//td[text()='%s']/following-sibling::td/input[@name='%s']"; 
	public static final String DYNAMIC_BUTTON ="//input[@type='%s']"; 
	public static final String DYNAMIC_FIELD_LABEL ="//tr//td[text()='%s']"; 
}
