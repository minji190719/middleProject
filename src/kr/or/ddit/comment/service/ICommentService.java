package kr.or.ddit.comment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.CommentVO;

public interface ICommentService {


	public List<CommentVO> selectAllComment();
	
	public List<CommentVO> selectCommentBoardNo(String board_no);
	
	public CommentVO selectComment_com_no(String com_no);
	/**
	 * select 기능 구현시 검색할 param 추가 하세요.
	 * 일단은 prod_id로만 넣었습니다. 
	 * @param prod_id
	 * @return
	 */
	public CommentVO selectComment(String mem_id);
	
	public int insertComment(CommentVO vo);
	
	public int updateComment(Map<String, Object> map);

	public int updateComment2(CommentVO vo);
	
	public int deleteComment(String mem_id);

	
	
	
	
}
