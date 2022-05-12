package nurhomestay.model;

import java.util.List;

public class Homestay {
	private int homestayId;
	private String home_name;
	private String home_address;
	private String home_desc;
	private double home_price;
	private double home_deposit;
	private List<Reservation> reservations;
	private List<Homestay> homestay;
	public boolean valid;
	
	public Homestay() {
		super();
	}

	public Homestay(String home_name, String home_address, String home_desc, double home_price, double home_deposit) {
		super();
		//this.homestayId = homestayId;
		this.home_name = home_name;
		this.home_address = home_address;
		this.home_desc = home_desc;
		this.home_price = home_price;
		this.home_deposit = home_deposit;
	}

	public int getHomestayId() {
		return homestayId;
	}
	
	public void setHomestayId(int homestayId) {
		this.homestayId = homestayId;
	}
	
	public String getHome_name() {
		return home_name;
	}
	
	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}
	
	public String getHome_address() {
		return home_address;
	}
	
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	
	public String getHome_desc() {
		return home_desc;
	}
	
	public void setHome_desc(String home_desc) {
		this.home_desc = home_desc;
	}
	
	public double getHome_price() {
		return home_price;
	}
	
	public void setHome_price(double home_price) {
		this.home_price = home_price;
	}
	
	public double getHome_deposit() {
		return home_deposit;
	}

	public void setHome_deposit(double home_deposit) {
		this.home_deposit = home_deposit;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Homestay> getAllHomestay(){
		return homestay;
	}
}
