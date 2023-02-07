package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient client;

	private static MemberDaoImpl dao;

	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> list = null;

		try {
			list = client.queryForList("member.selectAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		MemberVO vo = null;

		try {
			vo = (MemberVO) client.queryForObject("member.selectMember",
					mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public MemberVO getLoginMember(Map<String, Object> map) {
		MemberVO vo = null;

		try {
			vo = (MemberVO) client.queryForObject("member.getLoginMember", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public int insertMember(MemberVO vo) {
		int result = 0;
		Object obj = null;

		try {
			obj = client.insert("member.insertMember", vo);
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateMember(Map<String, Object> map) {
		int result = 0;

		try {
			result = client.update("member.updateMember", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateMember2(MemberVO vo) {
		int result = 0;

		try {
			result = client.update("member.updateMember2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteMember(String mem_id) {
		int result = 0;

		try {
			result = client.delete("member.deleteMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
