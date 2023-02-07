package kr.or.ddit.cart.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.SalesRequestVO;

public interface ICartDao {

	
	
	public List<CartVO> selectAllCart(String mem_id);
	
	public List<CartVO> selectCart_Returns(String mem_id);
	
	public CartVO selectCart(String cart_no);
	
	public CartVO selectCart2(Map<String,String> map);
	
	public List<CartVO> selectCart3(String pay_no);
	
	public int insertCart(CartVO vo);
	
	public int insertCart2(SalesRequestVO vo);
	
	public int updateCart(Map<String, Object> map);
	
	public int updateCart2(CartVO vo);
	
	public int updateCart3(Map<String,String> map);
	
	public int updateCart4(Map<String,String> map);
	
	public int updateCart5(Map<String,Object> map);
	
	public int deleteCart(String cart_no);
	
	
}
