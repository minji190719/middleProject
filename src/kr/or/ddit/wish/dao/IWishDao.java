package kr.or.ddit.wish.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.WishVO;

public interface IWishDao {
	//위시리스트는 보통 추가와 삭제기능이 있고 수정기능이 없어요. 일단 update를 넣어는 놨어요
	
	public List<WishVO> sellectAllWish(String mem_id);
	
	public WishVO selectWish(String wish_no);
	
	public WishVO checkWish(String prod_id);
	
	public int insertWish(WishVO vo);
	
	public int updateWish(Map<String, Object> map);
	
	public int updateWish2(WishVO vo);
	
	public int deleteWish(String wish_no);
	
}
