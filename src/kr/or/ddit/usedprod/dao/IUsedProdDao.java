package kr.or.ddit.usedprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.UsedProdVO;

public interface IUsedProdDao {
	public List<UsedProdVO> selectAllUsedProd();
	
	public UsedProdVO selectUsedProd(String u_prod_no);
	
	public int insertUsedProd(UsedProdVO vo);
	
	public int updateUsedProd(Map<String, Object> map);

	public int updateUsedProd2(UsedProdVO vo);
	
	public int deleteUsedProd(String u_prod_no);
	

}
