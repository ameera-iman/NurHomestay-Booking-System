package nurhomestay.model;
import java.util.Date;

public class Reservation {
	private int reserveid;
	private Date reservedate;
	private Date checkindate;
	private Date checkoutdate;
	private int custid;
	private int homestayid;
	private String home_name;
	private String custname;
	private double home_price;
	private double home_deposit;
	private double PaymentAmount;
	public boolean valid;
	
	
	public Reservation() {
		super();
	}
	
	
	public Reservation(Date dateRes, Date dateCheckIn, Date dateCheckOut,
			int custid, int homestayid) {
		super();
		reservedate = dateRes;
		checkindate = dateCheckIn;
		checkoutdate = dateCheckOut;
		this.custid = custid;
		this.homestayid = homestayid;
	}
	
	public int getReserveid() {
		return reserveid;
	}
	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}
	public Date getReservedate() {
		return reservedate;
	}
	public void setReservedate(Date dateRes) {
		reservedate = dateRes;
	}
	public Date getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(Date dateCheckIn) {
		checkindate = dateCheckIn;
	}
	public Date getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(Date dateCheckOut) {
		checkoutdate = dateCheckOut;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getHomestayid() {
		return homestayid;
	}
	public void setHomestayid(int homestayid) {
		this.homestayid = homestayid;
	}
	public String getHome_name() {
		return home_name;
	}
	
	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}
	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	public double getPaymentAmount() {
		return PaymentAmount;
	}
	public void setPaymentAmount(Double PaymentAmount) {
		this.PaymentAmount = PaymentAmount;
	}
	
	public double getHome_price() {
		return home_price;
	}
	public void setHome_price(double home_price) {
		this.home_price = home_price;
	}
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public double getHome_deposit() {
		return home_deposit;
	}

	public void setHome_deposit(double home_deposit) {
		this.home_deposit = home_deposit;
	}
	
}
