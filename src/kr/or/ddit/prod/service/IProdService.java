package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ProdVO;

public interface IProdService {
	public List<ProdVO> selectAllProd();
	
	public ProdVO selectProd_prod_id(String prod_id);
	
	public ProdVO selectProd_prod_name(String prod_name);
	
	public List<ProdVO> selectProd_lprod_gu(String lprod_gu);
	
	public List<ProdVO> selectProd_lprod_gu_price(Map<String, Object> map);
	
	public List<ProdVO> selectProd_lprod_gu_color(Map<String, Object> map);
	
	public List<ProdVO> selectProd_lprod_gu_color_all(Map<String, Object> map);

	public List<ProdVO> selectProd_lprod_gu2(ProdVO vo);

	public int insertProd(ProdVO vo);
	
	public int updateProd(Map<String, Object> map);
	
	public int updateProd2(ProdVO vo);
	
	public int deleteProd(String prod_id);

}
