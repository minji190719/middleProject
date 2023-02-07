package kr.or.ddit.sns.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SnsVO;

public interface ISnsService {
	//삭제 검색에 대한 파라미터가 애매함. 기능 만들때 잘 만들어서 써야함.
	
	public List<SnsVO> selectAllSns();
	
	public List<SnsVO> selectAllSns_Like(String mem_id);
	
	public SnsVO selectSns_no(String sns_no);
	
	public SnsVO selectSns_title(String sns_title);

	public List<SnsVO> selectSns_writer(String mem_id);
	
	public List<SnsVO> selectSns_prod_name(String prod_name);
	
	public int insertSns(SnsVO vo);
	
	public int updateSns(Map<String, Object> map);
	
	public int updateSns2(SnsVO vo);
	
	public int deleteSns(String sns_no);
	
	public int deleteSns_comment(String sns_no);
	
	public int deleteSns_like(String sns_no);
	
}
