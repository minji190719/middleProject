package kr.or.ddit.wish.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.WishVO;

public class WishDaoImpl implements IWishDao {
	private SqlMapClient client;
	private static WishDaoImpl dao;
	private WishDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	
	public static WishDaoImpl getInstance() {
		if(dao == null) dao = new WishDaoImpl();
		return dao;
	}

	@Override
	public List<WishVO> sellectAllWish(String mem_id) {
		List<WishVO> list = null;
		
		try {
			list = client.queryForList("wish.selectAllWish",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public WishVO selectWish(String wish_no) {
		WishVO vo = null;
		
		try {
			vo = (WishVO) client.queryForObject("wish.selectWish", wish_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertWish(WishVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("wish.insertWish", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(obj== null) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateWish(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("wish.updateWish", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateWish2(WishVO vo) {
		int result = 0;
		
		try {
			result = client.update("wish.updateWish2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteWish(String wish_no) {
		int result = 0;
		
		try {
			result = client.delete("wish.deleteWish", wish_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	@Override
	public WishVO checkWish(String prod_id) {
		WishVO vo = null;
		
		try {
			vo = (WishVO) client.queryForObject("wish.checkWish", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}



}
