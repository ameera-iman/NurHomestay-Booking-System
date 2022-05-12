package nurhomestay.model;

public class Staff {
	private String username;
	private int staffId;
	private String sta_name;
	private String sta_phoneNo;
	private String sta_email;
	private String sta_password;
	private String sta_address;
	private String role;
	private int managerId;
	private Staff managerIdStaff;
	public boolean valid;
	
	public Staff() {
		super();
	}
	
	public Staff(String username, String sta_name, String sta_phoneNo, String sta_email, String sta_address, String sta_password, int managerId,String role)
	{
		super();
		this.username = username;
		this.sta_name = sta_name;
		this.sta_phoneNo = sta_phoneNo;
		this.sta_email = sta_email;
		this.sta_address = sta_address;
		this.sta_password = sta_password;
		this.managerId = managerId;
		this.role = role;
	}

	public void setStaff(String username, String sta_name, String sta_phoneNo, String sta_email, String sta_address)
	{
		this.username = username;
		this.sta_name = sta_name;
		this.sta_phoneNo = sta_phoneNo;
		this.sta_email = sta_email;
		this.sta_address = sta_address;
		
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getSta_name() {
		return sta_name;
	}


	public void setSta_name(String sta_name) {
		this.sta_name = sta_name;
	}


	public String getSta_phoneNo() {
		return sta_phoneNo;
	}


	public void setSta_phoneNo(String sta_phoneNo) {
		this.sta_phoneNo = sta_phoneNo;
	}


	public String getSta_email() {
		return sta_email;
	}


	public void setSta_email(String sta_email) {
		this.sta_email = sta_email;
	}


	public String getSta_password() {
		return sta_password;
	}


	public void setSta_password(String sta_password) {
		this.sta_password = sta_password;
	}


	public String getSta_address() {
		return sta_address;
	}


	public void setSta_address(String sta_address) {
		this.sta_address = sta_address;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getRole() {
		return role;
	}

	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public Staff getManagerIdStaff() {
		return managerIdStaff;
	}


	public void setManagerIdStaff(Staff managerIdStaff) {
		this.managerIdStaff = managerIdStaff;
	}


	public boolean isValid() {
		return valid;
	}


	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getRoleManager() {
		// TODO Auto-generated method stub
		return role;
	}

}

