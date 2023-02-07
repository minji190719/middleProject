package kr.or.ddit.vo;

public class ReturnsVO {
	private String returns_no;
	private String cart_no;
	private String mem_id;
	private String returns_title;
	private String returns_content;
	private String returns_date;
	private String returns_photo;
	private String pay_date;
	private String prod_name;
	
	/////////////////////////////////////////
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	////////////////////////////////////////////
	
	public String getReturn_no() {
		return returns_no;
	}
	public void setReturn_no(String return_no) {
		this.returns_no = return_no;
	}
	public String getCart_no() {
		return cart_no;
	}
	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getReturn_title() {
		return returns_title;
	}
	public void setReturn_title(String return_title) {
		this.returns_title = return_title;
	}
	public String getReturn_content() {
		return returns_content;
	}
	public void setReturn_content(String return_content) {
		this.returns_content = return_content;
	}
	public String getReturn_date() {
		return returns_date;
	}
	public void setReturn_date(String return_date) {
		this.returns_date = return_date;
	}
	public String getReturn_photo() {
		return returns_photo;
	}
	public void setReturn_photo(String return_photo) {
		this.returns_photo = return_photo;
	}
}
