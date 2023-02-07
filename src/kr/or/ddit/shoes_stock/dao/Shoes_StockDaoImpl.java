package kr.or.ddit.shoes_stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Shoes_StockVO;

public class Shoes_StockDaoImpl implements IShoes_StockDao {
	private SqlMapClient client;
	private static Shoes_StockDaoImpl dao;
	
	private Shoes_StockDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static Shoes_StockDaoImpl getInstance() {
		if (dao == null) dao = new Shoes_StockDaoImpl();
		return dao;
	}

	@Override
	public List<Shoes_StockVO> selectAllShoes_Stock() {
		List<Shoes_StockVO> list = null;
		
		try {
			list = client.queryForList("shoes_stock.selectAllShoes_Stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public Shoes_StockVO selectShoes_Stock(String prod_id) {
		Shoes_StockVO vo = null;
		
		try {
			vo = (Shoes_StockVO) client.queryForObject("shoes_stock.selectShoes_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertShoes_Stock(Shoes_StockVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("shoes_stock.insertShoes_Stock", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateShoes_Stock(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("shoes_stock.updateShoes_Stock", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateShoes_Stock2(Shoes_StockVO vo) {
		int result = 0;
		
		try {
			result = client.update("shoes_stock.updateShoes_Stock2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteShoes_Stock(String prod_id) {
		int result = 0;
		
		try {
			result = client.delete("shoes_stock.deleteShoes_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
