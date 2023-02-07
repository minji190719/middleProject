package kr.or.ddit.comment.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.CommentVO;

public class CommentDaoImpl implements ICommentDao{

	private SqlMapClient client;
	
	private static CommentDaoImpl dao;
	
	private CommentDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static CommentDaoImpl getInstance() {
		
		if(dao ==null) dao = new CommentDaoImpl();
		return dao;
		
	}
	
	
	
	@Override
	public List<CommentVO> selectAllComment() {
		List<CommentVO> list = null;
		
		try {
			list = client.queryForList("comment.selectAllComment");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return list;
	
	
	}

	@Override
	public CommentVO selectComment(String mem_id) {
		CommentVO vo = null;
		
		try {
			vo = (CommentVO)client.queryForObject("comment.selectComment",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public CommentVO selectComment_com_no(String com_no) {
		CommentVO vo = null;
		
		try {
			vo = (CommentVO) client.queryForObject("comment.selectComment_com_no", com_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	@Override
	public int insertComment(CommentVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("comment.insertComment", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateComment(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("comment.updateComment", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateComment2(CommentVO vo) {
		int result = 0;
		
		try {
			result = client.update("comment.updateComment2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteComment(String com_no) {
		int result = 0;
		
		try {
			result = client.delete("comment.deleteComment", com_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	
	
	}

	@Override
	public List<CommentVO> selectCommentBoardNo(String board_no) {
		List<CommentVO> list = null;
		
		try {
			list = client.queryForList("comment.selectCommentBoardNo",board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	
	}



}
