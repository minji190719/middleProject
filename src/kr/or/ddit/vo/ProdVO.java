package kr.or.ddit.vo;

public class ProdVO {
	private String prod_id;
	private String lprod_gu;
	private String prod_name;
	private String prod_color;
	private int prod_price;
	private String prod_brand;
	private String prod_purpose;
	private String prod_sales;
	private int prod_tqty;
	private String prod_image;
	private String prod_content;
	private String prod_detail;
	private String lprod_name;
	
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_color() {
		return prod_color;
	}
	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_brand() {
		return prod_brand;
	}
	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}
	public String getProd_purpose() {
		return prod_purpose;
	}
	public void setProd_purpose(String prod_purpose) {
		this.prod_purpose = prod_purpose;
	}
	public String getProd_sales() {
		return prod_sales;
	}
	public void setProd_sales(String prod_sales) {
		this.prod_sales = prod_sales;
	}
	public int getProd_tqty() {
		return prod_tqty;
	}
	public void setProd_tqty(int prod_tqty) {
		this.prod_tqty = prod_tqty;
	}
	public String getProd_image() {
		return prod_image;
	}
	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}
	public String getProd_content() {
		return prod_content;
	}
	public void setProd_content(String prod_content) {
		this.prod_content = prod_content;
	}
	
	@Override
	public String toString() {
		return "ProdVO [prod_id=" + prod_id + ", lprod_gu=" + lprod_gu + ", prod_name=" + prod_name + ", prod_color="
				+ prod_color + ", prod_price=" + prod_price + ", prod_brand=" + prod_brand + ", prod_purpose="
				+ prod_purpose + ", prod_sales=" + prod_sales + ", prod_tqty=" + prod_tqty + ", prod_image="
				+ prod_image + ", prod_content=" + prod_content + ", prod_detail=" + prod_detail + ", lprod_name="
				+ lprod_name + "]";
	}
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	public String getLprod_name() {
		return lprod_name;
	}
	public void setLprod_name(String lprod_name) {
		this.lprod_name = lprod_name;
	}
	
	
	
	
}
