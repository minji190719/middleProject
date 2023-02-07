package kr.or.ddit.returns.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.ReturnsVO;

public class ReturnsDaoImpl implements IReturnsDao {
	private SqlMapClient client;
	private static ReturnsDaoImpl dao;
	
	private ReturnsDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ReturnsDaoImpl getInstance() {
		if (dao == null) dao = new ReturnsDaoImpl();
		return dao;
	}

	@Override
	public List<ReturnsVO> selectAllReturns() {
		List<ReturnsVO> list = null;
		
		try {
			list = client.queryForList("returns.selectAllReturns");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ReturnsVO selectReturns_mem_id(String mem_id) {
		ReturnsVO vo = null;
		
		try {
			vo = (ReturnsVO) client.queryForObject("returns.selectReturns_mem_id", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertReturns(ReturnsVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("returns.insertReturns", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateReturns(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("returns.updateReturns", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateReturns2(ReturnsVO vo) {
		int result = 0;
		
		try {
			result = client.update("returns.updateReturns2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteReturns(String returns_no) {
		int result = 0;
		
		try {
			result = client.delete("returns.deleteReturns", returns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ReturnsVO> selectReturns_cart(String mem_id) {
		List<ReturnsVO> list = null;
		
		try {
			list = client.queryForList("returns.selectReturns_cart", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ReturnsVO> selectReturns_mylist(String mem_id) {
		List<ReturnsVO> list = null;
		
		try {
			list = client.queryForList("returns.selectReturns_mylist", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ReturnsVO selectReturns_returns_no(Map<String, Object> map) {
		ReturnsVO vo = null;
		
		try {
			vo = (ReturnsVO) client.queryForObject("returns.selectReturns_returns_no", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int updateReturns_admin(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("returns.updateReturns_admin", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ReturnsVO selectReturns_admin_returns_no(String returns_no) {
		ReturnsVO vo = null;
		
		try {
			vo = (ReturnsVO) client.queryForObject("returns.selectReturns_admin_returns_no", returns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public List<ReturnsVO> selectAllReturns_admin() {
		List<ReturnsVO> list = null;
		
		try {
			list = client.queryForList("returns.selectAllReturns_admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateReturns_admin_cart_status(String cart_no) {
		int result = 0;
		
		try {
			result = client.update("returns.updateReturns_admin_cart_status", cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
