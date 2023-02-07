package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {
	private SqlMapClient client;
	private static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static NoticeDaoImpl getInstance() {
		if(dao == null) dao = new NoticeDaoImpl();
		return dao;
	}
	
	
	
	@Override
	public List<NoticeVO> selectAllNotice() {
		List<NoticeVO> list = null;
		
		try {
			list = client.queryForList("notice.selectAllNotice");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<NoticeVO> selectNotice_title(String notice_title) {
		List<NoticeVO> vo = null;
		
		try {
			vo = (List<NoticeVO>) client.queryForList("notice.selectNotice_title", notice_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("notice.insertNotice",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj == null) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateNotice(Map<String, Object> map) {
		
		int result = 0;
		
		try {
			result = client.update("notice.updateNotice", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateNotice2(NoticeVO vo) {
		int result = 0;
		
		try {
			result = client.update("notice.updateNotice2",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteNotice(int notice_no) {
		int result = 0;
		
		try {
			result = client.delete("notice.deleteNotice",notice_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NoticeVO selectNotice_no(int notice_no) {
		NoticeVO vo = null;
		try {
			vo =  (NoticeVO) client.queryForObject("notice.selectNotice_no", notice_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}


}
