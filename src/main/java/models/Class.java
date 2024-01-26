package models;

public class Class {
	private String idClass;
	private String nameClass;
	private int quantity;

	public Class(String idClass, String nameClass, int quantity) {
		super();
		this.idClass = idClass;
		this.nameClass = nameClass;
		this.quantity = quantity;
	}

	public Class() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Class [idClass=" + idClass + ", nameClass=" + nameClass + ", quantity=" + quantity + "]";
	}

	public String getIdClass() {
		return idClass;
	}

	public void setIdClass(String idClass) {
		this.idClass = idClass;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
