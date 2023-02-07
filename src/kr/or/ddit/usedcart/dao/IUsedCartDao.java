package kr.or.ddit.usedcart.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.UsedCartVO;

public interface IUsedCartDao {
	public List<UsedCartVO> selectAllUsedCart();
	
	public UsedCartVO selectUsedCart(String u_cart_no);
	
	public int insertUsedCart(UsedCartVO vo);
	
	public int updateUsedCart(Map<String, Object> map);
	
	public int updateUsedCart2(UsedCartVO vo);
	
	public int deleteUsedCart(String u_cart_no);


}
