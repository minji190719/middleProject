package kr.or.ddit.usedprod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.UsedProdVO;

public class UsedProdDaoImpl implements IUsedProdDao {
	private SqlMapClient client;
	private static UsedProdDaoImpl dao;
	
	private UsedProdDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static UsedProdDaoImpl getInstance() {
		if(dao == null) dao = new UsedProdDaoImpl();
		return dao;
	}
	

	@Override
	public List<UsedProdVO> selectAllUsedProd() {
		List<UsedProdVO> list = null;
		
		try {
			list = client.queryForList("usedprod.selectAllUsedProd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public UsedProdVO selectUsedProd(String u_prod_no) {
		UsedProdVO vo = null;
		
		try {
			vo = (UsedProdVO) client.queryForObject("usedprod.selectUsedProd", u_prod_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertUsedProd(UsedProdVO vo) {
		
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("usedprod.insertUsedProd",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj == null) {
			result= 1;
		}
		
		return result;
	}

	@Override
	public int updateUsedProd(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("usedprod.updateUsedProd", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateUsedProd2(UsedProdVO vo) {
		int result = 0;
		
		 try {
			result = client.update("usedprod.updateUsedProd2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return result;
	}

	@Override
	public int deleteUsedProd(String u_prod_no) {
		int result = 0;
		
		try {
			result = client.delete("usedprod.deleteUsedProd", u_prod_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
