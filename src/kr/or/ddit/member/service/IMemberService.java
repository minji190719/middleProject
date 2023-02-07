package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	
	public List<MemberVO> selectAllMember();
	
	public MemberVO selectMember(String mem_id);
	
	public MemberVO getLoginMember(Map<String, Object> map);
	
	public int insertMember(MemberVO vo);
	
	//update 메서드는 update 컬럼명이 유동적일 때 사용하세요.
	public int updateMember(Map<String, Object> map);

	public int updateMember2(MemberVO vo);
	
	public int deleteMember(String mem_id);
	
}
