package kr.or.ddit.usedcart.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.UsedCartVO;

public class UsedCartDaoImpl implements IUsedCartDao {
	private SqlMapClient client;
	private static UsedCartDaoImpl dao;
	
	private UsedCartDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static UsedCartDaoImpl getInstance() {
		if(dao == null) dao = new UsedCartDaoImpl();
		return dao;
	}

	@Override
	public List<UsedCartVO> selectAllUsedCart() {
		List<UsedCartVO> list = null;
		try {
			list = client.queryForList("usedcart.selectAllUsedCart");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public UsedCartVO selectUsedCart(String u_cart_no) {
		UsedCartVO vo = null;
		
		try {
			vo = (UsedCartVO) client.queryForObject("usedcart.selectUsedCart", u_cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertUsedCart(UsedCartVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("usedcart.insertUsedCart", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj == null) {
			result = 1;
		}
		
		
		return result;
	}

	@Override
	public int updateUsedCart(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("usedcart.updateUsedCart", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateUsedCart2(UsedCartVO vo) {
		int result = 0;
		
		try {
			result = client.update("usedcart.updateUsedCart2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteUsedCart(String u_cart_no) {
		int result = 0;
		
		try {
			result = client.delete("usedcart.deleteUsedCart", u_cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
