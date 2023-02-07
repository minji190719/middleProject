package kr.or.ddit.review.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReviewVO;

public interface iReviewService {
	public List<ReviewVO> selectAllReview();

	public List<ReviewVO> selectAllReview_prod(String prod_id);
	
	public ReviewVO selectReview_mem_id(String mem_id);
	
	
	public ReviewVO selectReview(String cart_no); //주의 - 기능 만들때 수정해서 사용할 것

	public ReviewVO selectReview_review_no(String review_no);
	
	public int insertReview(ReviewVO vo);
	
	public int updateReview(Map<String, Object> map);
	
	public int updateReview2(ReviewVO vo);
	
	public int deleteReview(String review_no);
	
}
