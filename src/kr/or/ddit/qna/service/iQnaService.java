package kr.or.ddit.qna.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QnaVO;

public interface iQnaService {
	public List<QnaVO> selectAllQna();
	
	public int selectAllCount();
	
	public QnaVO selectQna(String qna_no);
	
	public List<QnaVO> selectQna_title(String qna_title);
	
	public List<QnaVO> selectQna_mem_id(String mem_id);
	
	public List<QnaVO> selectQna_prod(String prod_id);
	
	public int insertQna(QnaVO vo);
	
	public int updateQna(Map<String, Object> map);
	
	public int updateQna2(QnaVO vo);
	
	public int deleteQna(String qna_no);

}
