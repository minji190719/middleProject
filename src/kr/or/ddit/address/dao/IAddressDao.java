package kr.or.ddit.address.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AddressVO;

public interface IAddressDao {
	public List<AddressVO> selectAllAddress();
	
	public AddressVO selectAddress(String mem_id); 
	
	public int insertAddress(AddressVO vo);
	
	public int updateAddress(Map<String, Object> map);
	
	public int updateAddress2(AddressVO vo);
	
	public int deleteAddress(String addr_no);
}
