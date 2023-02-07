package kr.or.ddit.vo;

public class SnsVO {
	private String sns_no;
	private String mem_id;
	private String sns_title;
	private String sns_date;
	private String sns_content;
	private int sns_like;
	private int sns_count;
	private String sns_photo;
	private String prod_name;
	
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getSns_no() {
		return sns_no;
	}
	public void setSns_no(String sns_no) {
		this.sns_no = sns_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getSns_title() {
		return sns_title;
	}
	public void setSns_title(String sns_title) {
		this.sns_title = sns_title;
	}
	public String getSns_date() {
		return sns_date;
	}
	public void setSns_date(String sns_date) {
		this.sns_date = sns_date;
	}
	public String getSns_content() {
		return sns_content;
	}
	public void setSns_content(String sns_content) {
		this.sns_content = sns_content;
	}
	public int getSns_like() {
		return sns_like;
	}
	public void setSns_like(int sns_like) {
		this.sns_like = sns_like;
	}
	public int getSns_count() {
		return sns_count;
	}
	public void setSns_count(int sns_count) {
		this.sns_count = sns_count;
	}
	public String getSns_photo() {
		return sns_photo;
	}
	public void setSns_photo(String sns_photo) {
		this.sns_photo = sns_photo;
	}
}
