package kr.or.ddit.like.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.LikeVO;

public interface ILikeService {
	
	public List<LikeVO> selectAllLike();
	
	public int selectLike_mem_id(Map<String, Object> map);
	
	public int insertLike(LikeVO vo);
	
	public int deleteLike(Map<String, Object> map);
}
