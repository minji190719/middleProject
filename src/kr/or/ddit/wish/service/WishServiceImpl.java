package kr.or.ddit.wish.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.WishVO;
import kr.or.ddit.wish.dao.IWishDao;
import kr.or.ddit.wish.dao.WishDaoImpl;

public class WishServiceImpl implements IWishService {
	private IWishDao dao;
	private static WishServiceImpl service;
	
	private WishServiceImpl() {
		dao = WishDaoImpl.getInstance();
	}
	
	public static WishServiceImpl getInstance() {
		if(service == null) service = new WishServiceImpl();
		return service;
	}

	@Override
	public List<WishVO> sellectAllWish(String mem_id) {
		return dao.sellectAllWish(mem_id);
	}

	@Override
	public WishVO selectWish(String wish_no) {
		return dao.selectWish(wish_no);
	}

	@Override
	public int insertWish(WishVO vo) {
		return dao.insertWish(vo);
	}

	@Override
	public int updateWish(Map<String, Object> map) {
		return dao.updateWish(map);
	}
	
	@Override
	public int updateWish2(WishVO vo) {
		return dao.updateWish2(vo);
	}

	@Override
	public int deleteWish(String wish_no) {
		return dao.deleteWish(wish_no);
	}

	@Override
	public WishVO checkWish(String prod_id) {
		// TODO Auto-generated method stub
		return dao.checkWish(prod_id);
	}


}
