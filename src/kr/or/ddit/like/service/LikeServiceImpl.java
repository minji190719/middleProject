package kr.or.ddit.like.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.like.dao.ILikeDao;
import kr.or.ddit.like.dao.LikeDaoImpl;
import kr.or.ddit.vo.LikeVO;

public class LikeServiceImpl implements ILikeService {
	private ILikeDao dao;
	private static LikeServiceImpl service;
	
	private LikeServiceImpl() {
		dao = LikeDaoImpl.getInstance();
	}
	
	public static LikeServiceImpl getInstance() {
		if (service == null) service = new LikeServiceImpl();
		return service;
	}

	@Override
	public List<LikeVO> selectAllLike() {
		return dao.selectAllLike();
	}

	@Override
	public int selectLike_mem_id(Map<String, Object> map) {
		return dao.selectLike_mem_id(map);
	}

	@Override
	public int insertLike(LikeVO vo) {
		return dao.insertLike(vo);
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		return dao.deleteLike(map);
	}

}
