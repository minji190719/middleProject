package kr.or.ddit.returns.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReturnsVO;

public interface IReturnsService {
	public List<ReturnsVO> selectAllReturns();
	
	public List<ReturnsVO> selectAllReturns_admin();
	
	public List<ReturnsVO> selectReturns_cart(String mem_id);
	
	public List<ReturnsVO> selectReturns_mylist(String mem_id);
	
	public ReturnsVO selectReturns_mem_id(String mem_id);
	
	public ReturnsVO selectReturns_returns_no(Map<String, Object> map);
	
	public ReturnsVO selectReturns_admin_returns_no(String returns_no);
	
	public int insertReturns(ReturnsVO vo);

	public int updateReturns(Map<String, Object> map);
	
	public int updateReturns_admin(Map<String, Object> map);
	
	public int updateReturns2(ReturnsVO vo);
	
	public int updateReturns_admin_cart_status(String cart_no);
	
	public int deleteReturns(String returns_no);
}
