package kr.or.ddit.returns.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.returns.dao.IReturnsDao;
import kr.or.ddit.returns.dao.ReturnsDaoImpl;
import kr.or.ddit.review.dao.IReviewDao;
import kr.or.ddit.review.dao.ReviewDaoImpl;
import kr.or.ddit.vo.ReturnsVO;

public class ReturnsServiceImpl implements IReturnsService {
	private IReturnsDao dao;
	private static ReturnsServiceImpl service;
	
	private ReturnsServiceImpl() {
		dao = ReturnsDaoImpl.getInstance();
	}
	
	public static ReturnsServiceImpl getInstance() {
		if (service == null) service = new ReturnsServiceImpl();
		return service;
	}

	@Override
	public List<ReturnsVO> selectAllReturns() {
		return dao.selectAllReturns();
	}

	@Override
	public ReturnsVO selectReturns_mem_id(String mem_id) {
		return dao.selectReturns_mem_id(mem_id);
	}

	@Override
	public int insertReturns(ReturnsVO vo) {
		return dao.insertReturns(vo);
	}

	@Override
	public int updateReturns(Map<String, Object> map) {
		return dao.updateReturns(map);
	}
	
	@Override
	public int updateReturns2(ReturnsVO vo) {
		return dao.updateReturns2(vo);
	}

	@Override
	public int deleteReturns(String returns_no) {
		return dao.deleteReturns(returns_no);
	}

	@Override
	public List<ReturnsVO> selectReturns_cart(String mem_id) {
		return dao.selectReturns_cart(mem_id);
	}

	@Override
	public List<ReturnsVO> selectReturns_mylist(String mem_id) {
		return dao.selectReturns_mylist(mem_id);
	}

	@Override
	public ReturnsVO selectReturns_returns_no(Map<String, Object> map) {
		return dao.selectReturns_returns_no(map);
	}

	@Override
	public int updateReturns_admin(Map<String, Object> map) {
		return dao.updateReturns_admin(map);
	}

	@Override
	public ReturnsVO selectReturns_admin_returns_no(String returns_no) {
		return dao.selectReturns_admin_returns_no(returns_no);
	}

	@Override
	public List<ReturnsVO> selectAllReturns_admin() {
		return dao.selectAllReturns_admin();
	}

	@Override
	public int updateReturns_admin_cart_status(String cart_no) {
		return dao.updateReturns_admin_cart_status(cart_no);
	}


}
