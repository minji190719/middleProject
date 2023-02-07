package kr.or.ddit.acc_stock.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Acc_StockVO;

public interface IAcc_StockDao {
	/**
	 * Acc_StockVO 테이블의 전체 데이터 가져오는 메서드
	 * @return 전체 LIST
	 */
	public List<Acc_StockVO> selectAllAcc_Stock();
	
	/**
	 * 상품 번호를 인수값으로 받아 해당 상품의 모든 사이즈 재고수량을
	 * 가져오는 메서드
	 * @param prod_id 상품명
	 * @return 해당 상품의 총재고량
	 */
	public Acc_StockVO selectAcc_Stock(String prod_id);
	
	public int insertAcc_Stock(Acc_StockVO vo);
	
	public int updateAcc_Stock(Map<String, Object> map);

	public int updateAcc_Stock2(Acc_StockVO vo);
	
	public int deleteAcc_Stock(String prod_id);
}
