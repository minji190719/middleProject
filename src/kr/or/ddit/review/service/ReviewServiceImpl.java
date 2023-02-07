package kr.or.ddit.review.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.review.dao.IReviewDao;
import kr.or.ddit.review.dao.ReviewDaoImpl;
import kr.or.ddit.vo.ReviewVO;

public class ReviewServiceImpl implements iReviewService {
	private IReviewDao dao;
	private static ReviewServiceImpl service;
	
	private ReviewServiceImpl() {
		dao = ReviewDaoImpl.getInstance();
	}
	
	public static ReviewServiceImpl getInstance() {
		if (service == null) service = new ReviewServiceImpl();
		return service;
	}

	@Override
	public List<ReviewVO> selectAllReview() {
		return dao.selectAllReview();
	}

	@Override
	public ReviewVO selectReview_mem_id(String mem_id) {
		return dao.selectReview_mem_id(mem_id);
	}

	@Override
	public ReviewVO selectReview(String cart_no) {
		return dao.selectReview(cart_no);
	}

	@Override
	public int insertReview(ReviewVO vo) {
		return dao.insertReview(vo);
	}

	@Override
	public int updateReview(Map<String, Object> map) {
		return dao.updateReview(map);
	}
	
	@Override
	public int updateReview2(ReviewVO vo) {
		return dao.updateReview2(vo);
	}

	@Override
	public int deleteReview(String review_no) {
		return dao.deleteReview(review_no);
	}

	@Override
	public List<ReviewVO> selectAllReview_prod(String prod_id) {
		return dao.selectAllReview_prod(prod_id);
	}

	@Override
	public ReviewVO selectReview_review_no(String review_no) {
		return dao.selectReview_review_no(review_no);
	}


}
