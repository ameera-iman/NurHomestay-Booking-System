package nurhomestay.model;

public class Customer {
	private int custId;
	private String username;
	private String cust_name;
	private String cust_phoneNo;
	private String cust_email;
	private String password;
	private String address;
	public boolean valid;
	
	public Customer() {
		super();
	}
	
	public Customer(String username, String cust_name, String cust_phoneNo, String cust_email, String address, String password) {
		super();
		this.username = username;
		this.cust_name = cust_name;
		this.cust_phoneNo = cust_phoneNo;
		this.cust_email = cust_email;
		this.address = address;
		this.password = password;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phoneNo() {
		return cust_phoneNo;
	}

	public void setCust_phoneNo(String cust_phoneNo) {
		this.cust_phoneNo = cust_phoneNo;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
