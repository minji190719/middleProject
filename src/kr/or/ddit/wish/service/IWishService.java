package kr.or.ddit.wish.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.WishVO;

public interface IWishService {
	
	public List<WishVO> sellectAllWish(String mem_id);
	
	public WishVO selectWish(String wish_no);
	
	public WishVO checkWish(String prod_id);
	
	public int insertWish(WishVO vo);
	
	public int updateWish(Map<String, Object> map);
	
	public int updateWish2(WishVO vo);
	
	public int deleteWish(String wish_no);

}
