package kr.or.ddit.qna.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.QnaVO;

public class QnaDaoImpl implements IQnaDao {
	private SqlMapClient client;
	private static QnaDaoImpl dao;
	
	private QnaDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static QnaDaoImpl getInstance() {
		if (dao == null) dao = new QnaDaoImpl();
		return dao;
	}

	@Override
	public List<QnaVO> selectAllQna() {
		List<QnaVO> list = null;
		
		try {
			list = client.queryForList("qna.selectAllQna");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int selectAllCount() {
		int result = 0;
		
		try {
			result = (int) client.queryForObject("qna.selectAllCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public QnaVO selectQna(String qna_no) {
		QnaVO vo = null;
		
		try {
			vo = (QnaVO) client.queryForObject("qna.selectQna", qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	@Override
	public List<QnaVO> selectQna_title(String qna_title) {
		List<QnaVO> list = null;
		
		try {
			list = client.queryForList("qna.selectQna_title", qna_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<QnaVO> selectQna_mem_id(String mem_id) {
		List<QnaVO> list = null;
		
		try {
			list = client.queryForList("qna.selectQna_mem_id", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public int insertQna(QnaVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("qna.insertQna", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateQna(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("qna.updateQna", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateQna2(QnaVO vo) {
		int result = 0;
		
		try {
			result = client.update("qna.updateQna2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteQna(String qna_no) {
		int result = 0;
		
		try {
			result = client.delete("qna.deleteQna", qna_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<QnaVO> selectQna_prod(String prod_id) {
		List<QnaVO> list = null;
		
		try {
			list = client.queryForList("qna.selectQna_prod", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}





}
