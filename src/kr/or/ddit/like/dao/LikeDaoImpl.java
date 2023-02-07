package kr.or.ddit.like.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.LikeVO;

public class LikeDaoImpl implements ILikeDao {
	private SqlMapClient client;
	private static LikeDaoImpl dao;
	
	private LikeDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static LikeDaoImpl getInstance() {
		if (dao == null) dao = new LikeDaoImpl();
		return dao;
	}

	@Override
	public List<LikeVO> selectAllLike() {
		List<LikeVO> list = null;
		
		try {
			list = client.queryForList("like.selectAllLike");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int selectLike_mem_id(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = (int) client.queryForObject("like.selectLike_mem_id", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertLike(LikeVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("like.insertLike", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.delete("like.deleteLike", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
