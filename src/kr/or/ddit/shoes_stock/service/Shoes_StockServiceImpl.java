package kr.or.ddit.shoes_stock.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.shoes_stock.dao.IShoes_StockDao;
import kr.or.ddit.shoes_stock.dao.Shoes_StockDaoImpl;
import kr.or.ddit.vo.Shoes_StockVO;

public class Shoes_StockServiceImpl implements IShoes_StockService {
	private IShoes_StockDao dao;
	private static Shoes_StockServiceImpl service;
	
	private Shoes_StockServiceImpl() {
		dao = Shoes_StockDaoImpl.getInstance();
	}
	
	public static Shoes_StockServiceImpl getInstance() {
		if (service == null) service = new Shoes_StockServiceImpl();
		return service;
	}

	@Override
	public List<Shoes_StockVO> selectAllShoes_Stock() {
		return dao.selectAllShoes_Stock();
	}

	@Override
	public Shoes_StockVO selectShoes_Stock(String prod_id) {
		return dao.selectShoes_Stock(prod_id);
	}

	@Override
	public int insertShoes_Stock(Shoes_StockVO vo) {
		return dao.insertShoes_Stock(vo);
	}

	@Override
	public int updateShoes_Stock(Map<String, Object> map) {
		return dao.updateShoes_Stock(map);
	}
	
	@Override
	public int updateShoes_Stock2(Shoes_StockVO vo) {
		return dao.updateShoes_Stock2(vo);
	}

	@Override
	public int deleteShoes_Stock(String prod_id) {
		return dao.deleteShoes_Stock(prod_id);
	}


}
