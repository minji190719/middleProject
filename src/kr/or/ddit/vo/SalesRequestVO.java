package kr.or.ddit.vo;

public class SalesRequestVO {
	private String req_no;
	private String mem_id;
	private String origin_name;
	private int origin_price;
	private int req_price;
	private String req_photo;
	private String req_detail;
	private String req_date;
	private int req_status;
	
	public String getReq_no() {
		return req_no;
	}
	public void setReq_no(String req_no) {
		this.req_no = req_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public int getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
	}
	public int getReq_price() {
		return req_price;
	}
	public void setReq_price(int req_price) {
		this.req_price = req_price;
	}
	public String getReq_photo() {
		return req_photo;
	}
	public void setReq_photo(String req_photo) {
		this.req_photo = req_photo;
	}
	public String getReq_detail() {
		return req_detail;
	}
	public void setReq_detail(String req_detail) {
		this.req_detail = req_detail;
	}
	public String getReq_date() {
		return req_date;
	}
	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}
	public int getReq_status() {
		return req_status;
	}
	public void setReq_status(int req_status) {
		this.req_status = req_status;
	}
	
}
