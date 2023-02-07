package kr.or.ddit.clothes_stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.Clothes_StockVO;

public class Clothes_StockDaoImpl implements IClothes_StockDao{
	
	private SqlMapClient client;
	
	private static Clothes_StockDaoImpl dao;
	
	private  Clothes_StockDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	
	}
	
	public static Clothes_StockDaoImpl getInstance() {
		if(dao==null) dao = new Clothes_StockDaoImpl();
		return dao;
	}
	
	

	@Override
	public List<Clothes_StockVO> selectAllClothes_Stock() {
		List<Clothes_StockVO> list = null;
		
		try {
			list = client.queryForList("clothes_stock.selectAllClothes_Stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Clothes_StockVO selectClothes_Stock(String prod_id) {
		Clothes_StockVO vo = null;
		
		try {
			vo = (Clothes_StockVO) client.queryForObject("clothes_stock.selectClothes_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
		
	}

	@Override
	public int insertClothes_Stock(Clothes_StockVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("clothes_stock.insertClothes_Stock", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateClothes_Stock(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("clothes_stock.updateClothes_Stock", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateClothes_Stock2(Clothes_StockVO vo) {
		int result = 0;
		
		try {
			result = client.update("clothes_stock.updateClothes_Stock2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteClothes_Stock(String prod_id) {
		int result = 0;
		
		try {
			result = client.delete("clothes_stock.deleteClothes_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
