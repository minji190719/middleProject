package kr.or.ddit.cart.service;

import java.security.Provider.Service;
import java.util.List;
import java.util.Map;

import kr.or.ddit.cart.dao.CartDaoImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.SalesRequestVO;

public class CartServiceImpl implements ICartService {

	private CartDaoImpl dao;
	
	private static CartServiceImpl service; 
	
	private  CartServiceImpl() {
		dao = CartDaoImpl.getInstance();
	}
	
	public static CartServiceImpl getInstance() {
		if(service ==null) service = new CartServiceImpl();
		return service;
	}
	
	
	@Override
	public List<CartVO> selectAllCart(String mem_id) {
		// TODO Auto-generated method stub
		return dao.selectAllCart(mem_id);
	}

	@Override
	public CartVO selectCart(String cart_no) {
		// TODO Auto-generated method stub
		return dao.selectCart(cart_no);
	}

	@Override
	public int insertCart(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.insertCart(vo);
	}
	
	@Override
	public int insertCart2(SalesRequestVO vo) {
		// TODO Auto-generated method stub
		return dao.insertCart2(vo);
	}

	@Override
	public int updateCart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.updateCart(map);
	}
	
	@Override
	public int updateCart2(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.updateCart2(vo);
	}

	@Override
	public int deleteCart(String cart_no) {
		// TODO Auto-generated method stub
		return dao.deleteCart(cart_no);
	}

	@Override
	public CartVO selectCart2(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectCart2(map);
	}

	@Override
	public int updateCart3(Map<String, String> map) {
		return dao.updateCart3(map);
	}

	@Override
	public int updateCart4(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.updateCart4(map);
	}

	@Override
	public int updateCart5(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.updateCart5(map);
	}

	@Override
	public List<CartVO> selectCart_Returns(String mem_id) {
		return dao.selectCart_Returns(mem_id);
	}

	@Override
	public List<CartVO> selectCart3(String pay_no) {
		// TODO Auto-generated method stub
		return dao.selectCart3(pay_no);
	}


	
	
	
	
	
}
