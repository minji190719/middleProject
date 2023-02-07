package kr.or.ddit.acc_stock.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;

public class Acc_StockDaoImpl implements IAcc_StockDao {
	private SqlMapClient client;
	private static Acc_StockDaoImpl dao;
	
	private Acc_StockDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static Acc_StockDaoImpl getInstance() {
		if (dao == null) dao = new Acc_StockDaoImpl();
		return dao;
	}

	@Override
	public List<Acc_StockVO> selectAllAcc_Stock() {
		List<Acc_StockVO> list = null;
		
		try {
			list = client.queryForList("acc_stock.selectAllAcc_Stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Acc_StockVO selectAcc_Stock(String prod_id) {
		Acc_StockVO vo = null;
		
		try {
			vo = (Acc_StockVO) client.queryForObject("acc_stock.selectAcc_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return vo;
	}

	@Override
	public int insertAcc_Stock(Acc_StockVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("acc_stock.insertAcc_Stock", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateAcc_Stock(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("acc_stock.updateAcc_Stock", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateAcc_Stock2(Acc_StockVO vo) {
		int result = 0;
		
		try {
			result = client.update("acc_stock.updateAcc_Stock2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteAcc_Stock(String prod_id) {
		int result = 0;
		
		try {
			result = client.delete("acc_stock.deleteAcc_Stock", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
