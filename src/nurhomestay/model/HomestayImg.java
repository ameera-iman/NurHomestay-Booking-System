package nurhomestay.model;

public class HomestayImg {

	private int imageId;
	private String home_image;
	private int homestayId;
	public boolean valid;
	
	public HomestayImg() {
		super();
	}
	
	public HomestayImg(String home_image,int homestayId ) {
		super();
		this.home_image = home_image;
		this.homestayId = homestayId;
	}
	
	public int getImageId() {
		return imageId;
	}


	public void setImageId(int imageId) {
		this.imageId = imageId;
	}


	public String getHome_image() {
		return home_image;
	}


	public void setHome_image(String home_image) {
		this.home_image = home_image;
	}


	public int getHomestayId() {
		return homestayId;
	}


	public void setHomestayId(int homestayId) {
		this.homestayId = homestayId;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}