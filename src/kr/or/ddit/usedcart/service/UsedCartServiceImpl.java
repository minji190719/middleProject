package kr.or.ddit.usedcart.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.usedcart.dao.IUsedCartDao;
import kr.or.ddit.usedcart.dao.UsedCartDaoImpl;
import kr.or.ddit.vo.UsedCartVO;

public class UsedCartServiceImpl implements IUsedCartService {
	private IUsedCartDao dao;
	private static UsedCartServiceImpl service;
	
	private UsedCartServiceImpl() {
		dao = UsedCartDaoImpl.getInstance();
	}
	
	public static UsedCartServiceImpl getInstance() {
		if(service == null) service = new UsedCartServiceImpl();
		return service;
	}

	@Override
	public List<UsedCartVO> selectAllUsedCart() {
		return dao.selectAllUsedCart();
	}

	@Override
	public UsedCartVO selectUsedCart(String u_cart_no) {
		return dao.selectUsedCart(u_cart_no);
	}

	@Override
	public int insertUsedCart(UsedCartVO vo) {
		return dao.insertUsedCart(vo);
	}

	@Override
	public int updateUsedCart(Map<String, Object> map) {
		return dao.updateUsedCart(map);
	}
	
	@Override
	public int updateUsedCart2(UsedCartVO vo) {
		return dao.updateUsedCart2(vo);
	}

	@Override
	public int deleteUsedCart(String u_cart_no) {
		return dao.deleteUsedCart(u_cart_no);
	}


}
