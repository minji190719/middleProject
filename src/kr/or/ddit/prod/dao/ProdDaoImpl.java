package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	private SqlMapClient client;
	private static ProdDaoImpl dao;
	
	private ProdDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ProdDaoImpl getInstance() {
		if (dao == null) dao = new ProdDaoImpl();
		return dao;
	}

	@Override
	public List<ProdVO> selectAllProd() {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectAllProd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO selectProd_prod_id(String prod_id) {
		ProdVO vo = null;
		
		try {
			vo = (ProdVO) client.queryForObject("prod.selectProd_prod_id", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public ProdVO selectProd_prod_name(String prod_name) {
		ProdVO vo = null;
		
		try {
			vo = (ProdVO) client.queryForObject("prod.selectProd_prod_name", prod_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertProd(ProdVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("prod.insertProd", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateProd(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("prod.updateProd", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateProd2(ProdVO vo) {
		int result = 0;
		
		try {
			result = client.update("prod.updateProd2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteProd(String prod_id) {
		int result = 0;
		
		try {
			result = client.delete("prod.deleteProd", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu(String lprod_gu) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd_lprod_gu",lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu2(ProdVO vo) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd_lprod_gu2",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu_color(Map<String, Object> map) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd_lprod_gu_color",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu_color_all(Map<String, Object> map) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd_lprod_gu_color_all",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu_price(Map<String, Object> map) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProd_lprod_gu_price", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


}
