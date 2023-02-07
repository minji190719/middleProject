package kr.or.ddit.review.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.ReviewVO;

public class ReviewDaoImpl implements IReviewDao {
	private SqlMapClient client;
	private static ReviewDaoImpl dao;
	
	private ReviewDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ReviewDaoImpl getInstance() {
		if (dao == null) dao = new ReviewDaoImpl();
		return dao;
	}

	@Override
	public List<ReviewVO> selectAllReview() {
		List<ReviewVO> list = null;
		
		try {
			list = client.queryForList("review.selectAllReview");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ReviewVO selectReview_mem_id(String mem_id) {
		ReviewVO vo = null;
		
		try {
			vo = (ReviewVO) client.queryForObject("review.selectReview_mem_id", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public ReviewVO selectReview(String cart_no) {
		ReviewVO vo = null;
		
		try {
			vo = (ReviewVO) client.queryForObject("review.selectReview", cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertReview(ReviewVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("review.insertReview", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateReview(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("review.updateReview", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateReview2(ReviewVO vo) {
		int result = 0;
		
		try {
			result = client.update("review.updateReview2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteReview(String review_no) {
		int result = 0;
		
		try {
			result = client.delete("review.deleteReview", review_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ReviewVO> selectAllReview_prod(String prod_id) {
		List<ReviewVO> list = null;
		
		try {
			list = client.queryForList("review.selectAllReview_prod", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ReviewVO selectReview_review_no(String review_no) {
		ReviewVO vo = null;
		
		try {
			vo = (ReviewVO) client.queryForObject("review.selectReview_review_no", review_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}



}
