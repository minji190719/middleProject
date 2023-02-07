package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao{
	private SqlMapClient client;
	private static LprodDaoImpl dao;
	
	private LprodDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<LprodVO> selectAllLprod() {
		List<LprodVO> list = null;
		
		try {
			list = client.queryForList("lprod.selectAllLprod");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public LprodVO selectLprod(String lprod_gu) {
		LprodVO vo = null;
		
		try {
			vo = (LprodVO) client.queryForObject("lprod.selectLprod", lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertLprod(LprodVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("lprod.insertLprod", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj == null) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateLprod(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("lprod.updateLprod", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateLprod2(LprodVO vo) {
		
		int result = 0;
		
		try {
			result = client.update("lprod.updateLprod2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteLprod(String lprod_gu) {
		int result = 0;
		
		try {
			result = client.delete("lprod.deleteLprod",lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
