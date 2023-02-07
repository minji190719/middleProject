package kr.or.ddit.shoes_stock.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.Shoes_StockVO;

public interface IShoes_StockDao {
	public List<Shoes_StockVO> selectAllShoes_Stock();
	
	public Shoes_StockVO selectShoes_Stock(String prod_id);
	
	public int insertShoes_Stock(Shoes_StockVO vo);
	
	public int updateShoes_Stock(Map<String, Object> map);
	
	public int updateShoes_Stock2(Shoes_StockVO vo);
	
	public int deleteShoes_Stock(String prod_id);
}
