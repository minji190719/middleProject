package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeDao {
	public List<NoticeVO> selectAllNotice();
	
	public List<NoticeVO> selectNotice_title(String notice_title);
	
	public NoticeVO selectNotice_no(int notice_no);
	
	public int insertNotice(NoticeVO vo);
	
	public int updateNotice(Map<String, Object> map);

	public int updateNotice2(NoticeVO vo);
	
	public int deleteNotice(int notice_no);
	
}
