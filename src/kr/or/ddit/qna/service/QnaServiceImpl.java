package kr.or.ddit.qna.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.dao.QnaDaoImpl;
import kr.or.ddit.vo.QnaVO;

public class QnaServiceImpl implements iQnaService {
	private IQnaDao dao;
	private static QnaServiceImpl service;
	
	private QnaServiceImpl() {
		dao = QnaDaoImpl.getInstance();
	}
	
	public static QnaServiceImpl getInstance() {
		if (service == null) service = new QnaServiceImpl();
		return service;
	}
	

	@Override
	public List<QnaVO> selectAllQna() {
		return dao.selectAllQna();
	}

	@Override
	public int selectAllCount() {
		return dao.selectAllCount();
	}
	
	@Override
	public QnaVO selectQna(String qna_no) {
		return dao.selectQna(qna_no);
	}
	
	@Override
	public List<QnaVO> selectQna_title(String qna_title) {
		return dao.selectQna_title(qna_title);
	}

	@Override
	public int insertQna(QnaVO vo) {
		return dao.insertQna(vo);
	}

	@Override
	public int updateQna(Map<String, Object> map) {
		return dao.updateQna(map);
	}
	
	@Override
	public int updateQna2(QnaVO vo) {
		return dao.updateQna2(vo);
	}

	@Override
	public int deleteQna(String qna_no) {
		return dao.deleteQna(qna_no);
	}

	@Override
	public List<QnaVO> selectQna_mem_id(String mem_id) {
		return dao.selectQna_mem_id(mem_id);
	}

	@Override
	public List<QnaVO> selectQna_prod(String prod_id) {
		return dao.selectQna_prod(prod_id);
	}


}
