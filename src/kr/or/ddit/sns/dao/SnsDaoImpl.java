package kr.or.ddit.sns.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.SnsVO;
import oracle.net.ano.Service;

public class SnsDaoImpl implements ISnsDao {
	private SqlMapClient client;
	private static SnsDaoImpl dao;
	
	private SnsDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static SnsDaoImpl getInstance() {
		if (dao == null) dao = new SnsDaoImpl();
		return dao;
	}
	
	@Override
	public List<SnsVO> selectAllSns() {
		List<SnsVO> list = null;
		
		try {
			list = client.queryForList("sns.selectAllSns");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<SnsVO> selectAllSns_Like(String mem_id) {
		List<SnsVO> list = null;
		
		try {
			list = client.queryForList("sns.selectAllSns_Like", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public SnsVO selectSns_title(String sns_title) {
		SnsVO vo = null;
		
		try {
			vo = (SnsVO) client.queryForObject("sns.selectSns_title", sns_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public List<SnsVO> selectSns_writer(String mem_id) {
		List<SnsVO> list = null;
		
		try {
			list = client.queryForList("sns.selectSns_writer", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertSns(SnsVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("sns.insertSns", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateSns(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("sns.updateSns", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateSns2(SnsVO vo) {
		int result = 0;
		
		try {
			result = client.update("sns.updateSns2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteSns(String sns_no) {
		int result = 0;
		
		try {
			result = client.delete("sns.deleteSns", sns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public SnsVO selectSns_no(String sns_no) {
		SnsVO vo = null;
		
		try {
			vo = (SnsVO) client.queryForObject("sns.selectSns_no", sns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public List<SnsVO> selectSns_prod_name(String prod_name) {
		List<SnsVO> list = null;
		
		try {
			list = client.queryForList("sns.selectSns_prod_name", prod_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int deleteSns_comment(String sns_no) {
		int result = 0;
		
		try {
			result = client.delete("sns.deleteSns_comment", sns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteSns_like(String sns_no) {
		int result = 0;
		
		try {
			result = client.delete("sns.deleteSns_like", sns_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}



}
