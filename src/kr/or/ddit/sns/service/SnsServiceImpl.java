package kr.or.ddit.sns.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.sns.dao.ISnsDao;
import kr.or.ddit.sns.dao.SnsDaoImpl;
import kr.or.ddit.vo.SnsVO;

public class SnsServiceImpl implements ISnsService {
	private ISnsDao dao;
	private static SnsServiceImpl service;
	
	private SnsServiceImpl() {
		dao = SnsDaoImpl.getInstance();
	}
	
	public static SnsServiceImpl getInstance() {
		if (service == null) service = new SnsServiceImpl();
		return service;
	}
	
	@Override
	public List<SnsVO> selectAllSns() {
		return dao.selectAllSns();
	}

	@Override
	public List<SnsVO> selectAllSns_Like(String mem_id) {
		return dao.selectAllSns_Like(mem_id);
	}
	
	@Override
	public SnsVO selectSns_title(String sns_title) {
		return dao.selectSns_title(sns_title);
	}

	@Override
	public List<SnsVO> selectSns_writer(String mem_id) {
		return dao.selectSns_writer(mem_id);
	}

	@Override
	public int insertSns(SnsVO vo) {
		return dao.insertSns(vo);
	}

	@Override
	public int updateSns(Map<String, Object> map) {
		return dao.updateSns(map);
	}
	
	@Override
	public int updateSns2(SnsVO vo) {
		return dao.updateSns2(vo);
	}

	@Override
	public int deleteSns(String sns_no) {
		return dao.deleteSns(sns_no);
	}

	@Override
	public SnsVO selectSns_no(String sns_no) {
		return dao.selectSns_no(sns_no);
		
	}

	@Override
	public List<SnsVO> selectSns_prod_name(String prod_name) {
		return dao.selectSns_prod_name(prod_name);
	}

	@Override
	public int deleteSns_comment(String sns_no) {
		return dao.deleteSns_comment(sns_no);
	}

	@Override
	public int deleteSns_like(String sns_no) {
		return dao.deleteSns_like(sns_no);
	}



}
