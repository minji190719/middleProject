package kr.or.ddit.cart.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.SalesRequestVO;

public class CartDaoImpl implements ICartDao{
	
	
	private SqlMapClient client;
	
	private static CartDaoImpl dao;
	
	private CartDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
		
	}
	
	
	public static CartDaoImpl getInstance() {
		if(dao ==null) dao = new CartDaoImpl();
		return dao;
	}
	
	
	

	@Override
	public List<CartVO> selectAllCart(String mem_id) {
		List<CartVO> list = null;
		
		try {
			
			list = client.queryForList("cart.selectAllCart", mem_id);
			System.out.println("dao cart list 확인 :" + list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public CartVO selectCart(String cart_no) {
		CartVO vo = null;
		
		try {
			vo = (CartVO) client.queryForObject("cart.selectCart", cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return vo;
	}

	@Override
	public int insertCart(CartVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("cart.insertCart", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}
	
	@Override
	public int insertCart2(SalesRequestVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("cart.insertCart2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateCart(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("cart.updateCart", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateCart2(CartVO vo) {
		int result = 0;
		
		try {
			result = client.update("cart.updateCart2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteCart(String cart_no) {
		int result = 0;
		
		try {
			result = client.delete("cart.deleteCart", cart_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public CartVO selectCart2(Map<String, String> map) {
		CartVO vo = null;
		
		try {
			vo = (CartVO) client.queryForObject("cart.selectCart2", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return vo;
	}


	@Override
	public int updateCart3(Map<String, String> map) {
		int result = 0;
		
		try {
			result = client.update("cart.updateCart3", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public int updateCart4(Map<String, String> map) {
		int result = 0;
		
		try {
			result = client.update("cart.updateCart4", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public int updateCart5(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("cart.updateCart5", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public List<CartVO> selectCart_Returns(String mem_id) {
		List<CartVO> list = null;
		
		try {
			list = client.queryForList("cart.selectCart_Returns", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public List<CartVO> selectCart3(String pay_no) {
		List<CartVO> list = null;
		
		try {
			list = client.queryForList("cart.selectCart3", pay_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}



}
