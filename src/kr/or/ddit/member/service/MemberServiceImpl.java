package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	private MemberDaoImpl dao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl(){
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {	
		if(service ==null) service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public List<MemberVO> selectAllMember() {
		return dao.selectAllMember();
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		return dao.selectMember(mem_id);
	}

	@Override
	public MemberVO getLoginMember(Map<String, Object> map) {
		return dao.getLoginMember(map);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int updateMember(Map<String, Object> map) {
		return dao.updateMember(map);
	}
	
	@Override
	public int updateMember2(MemberVO vo) {
		return dao.updateMember2(vo);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}


}
