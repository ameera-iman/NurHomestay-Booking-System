package nurhomestay.model;

public class Staff {

	private String staffId;
	private String staffName;
	private String phoneNo;
	private String address;
	private String email;
	private String password;
	private String adminId;
	
	public Staff(String staffid,String staffName,String phoneNo,String address,String email,String password,String adminId)
	{
		this.staffId = staffId;
		this.staffName = staffName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.password = password;
		this.adminId = adminId;	
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	
	
}
