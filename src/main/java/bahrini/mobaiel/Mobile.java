package bahrini.mobaiel;

public class Mobile {
	protected int mobile_id;
	protected String refrence;
	protected String brand;
	protected float price;

	public Mobile() {
	}

	public Mobile(int mobile_idid) {
		this.mobile_id = mobile_idid;
	}

	public Mobile(int mobile_id, String refrence, String brand, float price) {
		this(refrence, brand, price);
		this.mobile_id = mobile_id;
	}
	
	public Mobile(String refrence, String brand, float price) {
		this.refrence = refrence;
		this.brand = brand;
		this.price = price;
	}
	public int getMobile_id() {
		return mobile_id;
	}

	public void setMobile_id(int mobile_id) {
		this.mobile_id = mobile_id;
	}

	public String getRefrence() {
		return refrence;
	}

	public void setRefrence(String refrence) {
		this.refrence = refrence;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}




}
