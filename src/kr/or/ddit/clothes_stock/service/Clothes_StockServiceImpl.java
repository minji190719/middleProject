package kr.or.ddit.clothes_stock.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.clothes_stock.dao.Clothes_StockDaoImpl;
import kr.or.ddit.clothes_stock.dao.IClothes_StockDao;
import kr.or.ddit.vo.Clothes_StockVO;

public class Clothes_StockServiceImpl implements IClothes_StockService{

	private IClothes_StockDao dao;
	
	private static Clothes_StockServiceImpl service;
	
	private Clothes_StockServiceImpl() {
		dao = Clothes_StockDaoImpl.getInstance();
		
	}
	
	public static Clothes_StockServiceImpl getInstance() {
		if(service ==null) service = new Clothes_StockServiceImpl();
		return service;
	}
	
	
	
	@Override
	public List<Clothes_StockVO> selectAllClothes_Stock() {
		// TODO Auto-generated method stub
		return dao.selectAllClothes_Stock();
	}

	@Override
	public Clothes_StockVO selectClothes_Stockk(String prod_id) {
		// TODO Auto-generated method stub
		return dao.selectClothes_Stock(prod_id);
	}


	@Override
	public int insertClothes_Stock(Clothes_StockVO vo) {
		// TODO Auto-generated method stub
		return dao.insertClothes_Stock(vo);
	}

	@Override
	public int updateClothes_Stock(Map<String, Object> map) {
		return dao.updateClothes_Stock(map);
	}
	
	@Override
	public int updateClothes_Stock2(Clothes_StockVO vo) {
		// TODO Auto-generated method stub
		return dao.updateClothes_Stock2(vo);
	}

	@Override
	public int deleteClothes_Stock(String prod_id) {
		// TODO Auto-generated method stub
		return dao.deleteClothes_Stock(prod_id);
	}



}
