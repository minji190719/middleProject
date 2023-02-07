package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	private ILprodDao dao;
	private static LprodServiceImpl service;

	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	public static LprodServiceImpl getInstance() {
		if(service == null) service = new LprodServiceImpl();
		return service;
	}
	
	

	@Override
	public List<LprodVO> selectAllLprod() {
		return dao.selectAllLprod();
	}

	@Override
	public LprodVO selectLprod(String lprod_gu) {
		return dao.selectLprod(lprod_gu);
	}

	@Override
	public int insertLprod(LprodVO vo) {
		return dao.insertLprod(vo);
	}

	@Override
	public int updateLprod(Map<String, Object> map) {
		return dao.updateLprod(map);
	}
	
	@Override
	public int updateLprod2(LprodVO vo) {
		return dao.updateLprod2(vo);
	}

	@Override
	public int deleteLprod(String lprod_gu) {
		return dao.deleteLprod(lprod_gu);
	}


}
