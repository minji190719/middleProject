package kr.or.ddit.salesrequest.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SalesRequestVO;

public interface ISalesRequestDao {
	public List<SalesRequestVO> selectAllSalseRequest();

	public List<SalesRequestVO> selectAllShowProd(int req_status);
	
	public List<SalesRequestVO> selectSalesRequest_writer(String mem_id);
	
	public SalesRequestVO selectSalesRequest_req_no(String req_no);
	
	public int insertSalesRequest(SalesRequestVO vo);
	
	public int updateSalesRequest(Map<String, Object> map);
	
	public int updateSalesRequest_re(Map<String, Object> map);

	public int updateSalesRequest2(SalesRequestVO vo);
	
	public int deleteSalesRequest(String req_no);
	
	public int updateSalesRequest3(String req_no);
	
}
