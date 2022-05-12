package nurhomestay.model;

import java.util.Date;

public class Payment {
	private int payment_id;
	private Date payment_date;
	private double paymentAmount;
	private String status;
	private int reserveid;
	private int staffid;
	private int custid;
	private String payment_status;
	private String home_name;
	private String year;
	public boolean valid;
	
	public Payment() {
		super();
	}

	public Payment(int payment_id, Date payment_date, double paymentAmount, String status) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.paymentAmount = paymentAmount;
		this.status = status;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status= status;
	}
	
	public int getReserveid() {
		return reserveid;
	}

	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getHome_name() {
		return home_name;
	}
	
	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}

	public String getPayment_status() {
		return payment_status;
	}
	
	public  String getYear() {
		return year;
	}

	public void setYear( String year) {
		this.year = year;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}