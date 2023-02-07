package kr.or.ddit.comment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.comment.dao.CommentDaoImpl;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.CommentVO;

public class CommentSericeImpl implements ICommentService{

	private CommentDaoImpl dao;
	
	private static CommentSericeImpl service;
	
	private CommentSericeImpl() {
		dao = CommentDaoImpl.getInstance();
		
	}
	
	public static CommentSericeImpl getInstance() {
		if(service ==null)service = new CommentSericeImpl();
		return service;
	}
	
	@Override
	public List<CommentVO> selectAllComment() {
		return dao.selectAllComment();
	}

	@Override
	public CommentVO selectComment(String mem_id) {
		return dao.selectComment(mem_id);
	}

	@Override
	public CommentVO selectComment_com_no(String com_no) {
		return dao.selectComment_com_no(com_no);
	}
	
	@Override
	public int insertComment(CommentVO vo) {
		return dao.insertComment(vo);
	}

	@Override
	public int updateComment(Map<String, Object> map) {
		return dao.updateComment(map);
	}
	
	@Override
	public int updateComment2(CommentVO vo) {
		return dao.updateComment2(vo);
	}

	@Override
	public int deleteComment(String com_no) {
		return dao.deleteComment(com_no);
	}

	@Override
	public List<CommentVO> selectCommentBoardNo(String board_no) {
		
		return dao.selectCommentBoardNo(board_no);
	}


	

	
}
