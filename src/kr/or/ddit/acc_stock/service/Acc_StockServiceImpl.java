package kr.or.ddit.acc_stock.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.acc_stock.dao.Acc_StockDaoImpl;
import kr.or.ddit.acc_stock.dao.IAcc_StockDao;
import kr.or.ddit.vo.Acc_StockVO;

public class Acc_StockServiceImpl implements IAcc_StockService {
	private IAcc_StockDao dao;
	private static Acc_StockServiceImpl service;
	
	private Acc_StockServiceImpl() {
		dao = Acc_StockDaoImpl.getInstance();
	}
	
	public static Acc_StockServiceImpl getInstance() {
		if (service == null) service = new Acc_StockServiceImpl();
		return service;
	}
	
	@Override
	public List<Acc_StockVO> selectAllAcc_Stock() {
		return dao.selectAllAcc_Stock();
	}

	@Override
	public Acc_StockVO selectAcc_Stock(String prod_id) {
		return dao.selectAcc_Stock(prod_id);
	}

	@Override
	public int insertAcc_Stock(Acc_StockVO vo) {
		return dao.insertAcc_Stock(vo);
	}

	@Override
	public int updateAcc_Stock(Map<String, Object> map) {
		return dao.updateAcc_Stock(map);
	}
	
	@Override
	public int updateAcc_Stock2(Acc_StockVO vo) {
		return dao.updateAcc_Stock2(vo);
	}

	@Override
	public int deleteAcc_Stock(String prod_id) {
		return dao.deleteAcc_Stock(prod_id);
	}


}
