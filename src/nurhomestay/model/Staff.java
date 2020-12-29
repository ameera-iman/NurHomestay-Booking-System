package nurhomestay.model;

public class Staff {

	private int staffId;
	private String staffName;
	private String phoneNo;
	private String address;
	private String email;
	private String password;
	private int adminId;
	
	public Staff(int staffid,String staffName,String phoneNo,String address,String email,String password,int adminId)
	{
		this.staffId = staffId;
		this.staffName = staffName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.password = password;
		this.adminId = adminId;	
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
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
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	
}
