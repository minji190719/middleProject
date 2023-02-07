package kr.or.ddit.clothes_stock.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Clothes_StockVO;

public interface IClothes_StockDao {

	
	public List<Clothes_StockVO> selectAllClothes_Stock();

	public Clothes_StockVO selectClothes_Stock(String prod_id);
	
	public int insertClothes_Stock(Clothes_StockVO vo);
	
	public int updateClothes_Stock(Map<String, Object> map);
	
	public int updateClothes_Stock2(Clothes_StockVO vo);
	
	public int deleteClothes_Stock(String prod_id);
	
	
	
}
