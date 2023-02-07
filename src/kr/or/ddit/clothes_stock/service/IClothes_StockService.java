package kr.or.ddit.clothes_stock.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Clothes_StockVO;


public interface IClothes_StockService {

	
	public List<Clothes_StockVO> selectAllClothes_Stock();
	
	/**
	 * 상품 번호를 인수값으로 받아 해당 상품의 모든 사이즈 재고수량을
	 * 가져오는 메서드
	 * @param prod_id 상품명
	 * @return 해당 상품의 총재고량
	 */
	public Clothes_StockVO selectClothes_Stockk(String prod_id);
	
	public int insertClothes_Stock(Clothes_StockVO vo);
	
	public int updateClothes_Stock(Map<String, Object> map);
	
	public int updateClothes_Stock2(Clothes_StockVO vo);
	
	public int deleteClothes_Stock(String prod_id);
	
}
