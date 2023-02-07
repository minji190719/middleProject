package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	private IProdDao dao;
	private static ProdServiceImpl service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static ProdServiceImpl getInstance() {
		if (service == null) service = new ProdServiceImpl();
		return service;
	}

	@Override
	public List<ProdVO> selectAllProd() {
		return dao.selectAllProd();
	}

	@Override
	public ProdVO selectProd_prod_id(String prod_id) {
		return dao.selectProd_prod_id(prod_id);
	}

	@Override
	public ProdVO selectProd_prod_name(String prod_name) {
		return dao.selectProd_prod_name(prod_name);
	}

	@Override
	public int insertProd(ProdVO vo) {
		return dao.insertProd(vo);
	}

	@Override
	public int updateProd(Map<String, Object> map) {
		return dao.updateProd(map);
	}
	
	@Override
	public int updateProd2(ProdVO vo) {
		return dao.updateProd2(vo);
	}

	@Override
	public int deleteProd(String prod_id) {
		return dao.deleteProd(prod_id);
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu(String lprod_gu) {
		return dao.selectProd_lprod_gu(lprod_gu);
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu2(ProdVO vo) {
		// TODO Auto-generated method stub
		return dao.selectProd_lprod_gu2(vo);
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu_color(Map<String, Object> map) {
		return dao.selectProd_lprod_gu_color(map);
	}
	
	@Override
	public List<ProdVO> selectProd_lprod_gu_color_all(Map<String, Object> map) {
		return dao.selectProd_lprod_gu_color_all(map);
	}

	@Override
	public List<ProdVO> selectProd_lprod_gu_price(Map<String, Object> map) {
		return dao.selectProd_lprod_gu_price(map);
	}


}
