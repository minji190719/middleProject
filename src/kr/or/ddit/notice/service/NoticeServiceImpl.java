package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService {
	private INoticeDao dao;
	private static NoticeServiceImpl service;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service == null) service = new NoticeServiceImpl();
		return service;
	}
	
	

	@Override
	public List<NoticeVO> selectAllNotice() {
		return dao.selectAllNotice();
	}

	@Override
	public List<NoticeVO> selectNotice_title(String notice_title) {
		return dao.selectNotice_title(notice_title);
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return dao.insertNotice(vo);
	}

	@Override
	public int updateNotice(Map<String, Object> map) {
		return dao.updateNotice(map);
	}
	
	@Override
	public int updateNotice2(NoticeVO vo) {
		return dao.updateNotice2(vo);
	}

	@Override
	public int deleteNotice(int notice_no) {
		return dao.deleteNotice(notice_no);
	}

	@Override
	public NoticeVO selectNotice_no(int notice_no) {
		return dao.selectNotice_no(notice_no);
	}


}
