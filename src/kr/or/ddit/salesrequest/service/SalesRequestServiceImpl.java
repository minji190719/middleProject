package kr.or.ddit.salesrequest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.salesrequest.dao.ISalesRequestDao;
import kr.or.ddit.salesrequest.dao.SalesRequestDaoImpl;
import kr.or.ddit.vo.SalesRequestVO;

public class SalesRequestServiceImpl implements ISalesRequestService {
	private ISalesRequestDao dao;
	private static SalesRequestServiceImpl service;
	
	private SalesRequestServiceImpl() {
		dao = SalesRequestDaoImpl.getInstance();
	}
	
	public static SalesRequestServiceImpl getInstance() {
		if (service == null) service = new SalesRequestServiceImpl();
		return service;
	}
	
	@Override
	public List<SalesRequestVO> selectAllSalseRequest() {
		return dao.selectAllSalseRequest();
	}
	
	@Override
	public List<SalesRequestVO> selectAllShowProd(int req_status) {
		return dao.selectAllShowProd(req_status);
	}

	@Override
	public List<SalesRequestVO> selectSalesRequest_writer(String mem_id) {
		return dao.selectSalesRequest_writer(mem_id);
	}

	@Override
	public SalesRequestVO selectSalesRequest_req_no(String req_no) {
		return dao.selectSalesRequest_req_no(req_no);
	}

	@Override
	public int insertSalesRequest(SalesRequestVO vo) {
		return dao.insertSalesRequest(vo);
	}

	@Override
	public int updateSalesRequest(Map<String, Object> map) {
		return dao.updateSalesRequest(map);
	}
	
	@Override
	public int updateSalesRequest2(SalesRequestVO vo) {
		return dao.updateSalesRequest2(vo);
	}

	@Override
	public int deleteSalesRequest(String req_no) {
		return dao.deleteSalesRequest(req_no);
	}

	@Override
	public int updateSalesRequest3(String req_no) {
		return dao.updateSalesRequest3(req_no);
	}

	@Override
	public int updateSalesRequest_re(Map<String, Object> map) {
		return dao.updateSalesRequest_re(map);
	}



}
