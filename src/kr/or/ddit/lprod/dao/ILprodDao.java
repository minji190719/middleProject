package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.LprodVO;

public interface ILprodDao {
	
	public List<LprodVO> selectAllLprod();
	
	public LprodVO selectLprod(String lprod_gu);
	
	public int insertLprod(LprodVO vo);
	
	public int updateLprod(Map<String, Object> map);
	
	public int updateLprod2(LprodVO vo);
	
	public int deleteLprod(String lprod_gu);

}
