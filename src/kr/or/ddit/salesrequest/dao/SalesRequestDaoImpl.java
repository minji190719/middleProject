package kr.or.ddit.salesrequest.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.SalesRequestVO;

public class SalesRequestDaoImpl implements ISalesRequestDao {
	private SqlMapClient client;
	private static SalesRequestDaoImpl dao;
	
	private SalesRequestDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static SalesRequestDaoImpl getInstance() {
		if (dao == null) dao = new SalesRequestDaoImpl();
		return dao;
	}

	@Override
	public List<SalesRequestVO> selectAllSalseRequest() {
		List<SalesRequestVO> list = null;
		
		try {
			list = client.queryForList("salesrequest.selectAllSalesRequest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public List<SalesRequestVO> selectAllShowProd(int req_status) {
		List<SalesRequestVO> list = null;
		
		try {
			list = client.queryForList("salesrequest.selectAllShowProd", req_status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<SalesRequestVO> selectSalesRequest_writer(String mem_id) {
		List<SalesRequestVO> list = null;
		
		try {
			list = client.queryForList("salesrequest.selectSalesRequest_writer", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public SalesRequestVO selectSalesRequest_req_no(String req_no) {
		SalesRequestVO vo = null;
		
		try {
			vo = (SalesRequestVO) client.queryForObject("salesrequest.selectSalesRequest_req_no", req_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertSalesRequest(SalesRequestVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("salesrequest.insertSalesRequest", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateSalesRequest(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("salesrequest.updateSalesRequest", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateSalesRequest_re(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("salesrequest.updateSalesRequest_re", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateSalesRequest2(SalesRequestVO vo) {
		int result = 0;
		
		try {
			result = client.update("salesrequest.updateSalesRequest2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteSalesRequest(String req_no) {
		int result = 0;
		
		try {
			result = client.delete("salesrequest.deleteSalesRequest", req_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateSalesRequest3(String req_no) {
		int result = 0;
		
		try {
			result = client.update("salesrequest.updateSalesRequest3", req_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
