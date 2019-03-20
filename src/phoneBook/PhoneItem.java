package phoneBook;

public class PhoneItem {
	//field
	private String name;
	private String telNum;
	
	//constructor method
	public PhoneItem() {	
	}

	public PhoneItem(String name, String telNum) {
		super();
		this.name = name;
		this.telNum = telNum;
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	//toString override
	@Override
	public String toString() {
		return "이름: " + name + ", 전화번호: " + telNum;
	}
	
}//end of class
