package nurhomestay.model;

import java.util.Date;

public class Onlinepayment extends Payment{
	private String accName;
	private String bankName;
	public boolean valid;
	
	public Onlinepayment() {
		super();
	}
	
	public Onlinepayment(int payment_id, Date payment_date, double paymentAmount,  String accName, String bankName, String status) {
		super(payment_id, payment_date, paymentAmount, status);
		this.accName = accName;
		this.bankName = bankName;
	}
	
	

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}