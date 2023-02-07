package kr.or.ddit.usedprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.usedprod.dao.IUsedProdDao;
import kr.or.ddit.usedprod.dao.UsedProdDaoImpl;
import kr.or.ddit.vo.UsedProdVO;

public class UsedProdServiceImpl implements IUsedProdService {
	private IUsedProdDao dao;
	private static UsedProdServiceImpl service;
	
	private UsedProdServiceImpl() {
		dao = UsedProdDaoImpl.getInstance();
	}
	
	public static UsedProdServiceImpl getInstance() {
		if(service == null) service = new UsedProdServiceImpl();
		return service;
	}
	
	@Override
	public List<UsedProdVO> selectAllUsedProd() {
		return dao.selectAllUsedProd();
	}

	@Override
	public UsedProdVO selectUsedProd(String u_prod_no) {
		return dao.selectUsedProd(u_prod_no);
	}

	@Override
	public int insertUsedProd(UsedProdVO vo) {
		return dao.insertUsedProd(vo);
	}

	@Override
	public int updateUsedProd(Map<String, Object> map) {
		return dao.updateUsedProd(map);
	}
	
	@Override
	public int updateUsedProd2(UsedProdVO vo) {
		return dao.updateUsedProd2(vo);
	}

	@Override
	public int deleteUsedProd(String u_prod_no) {
		return dao.deleteUsedProd(u_prod_no);
	}


}
