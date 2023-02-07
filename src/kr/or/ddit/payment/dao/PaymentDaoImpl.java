package kr.or.ddit.payment.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.PaymentVO;

public class PaymentDaoImpl implements IPaymentDao {
	private SqlMapClient client;
	private static PaymentDaoImpl dao;
	
	private PaymentDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static PaymentDaoImpl getInstance() {
		if (dao == null) dao = new PaymentDaoImpl();
		return dao;
	}

	@Override
	public List<PaymentVO> selectAllPayment() {
		List<PaymentVO> list = null;
		
		try {
			list = client.queryForList("payment.selectAllPayment");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public PaymentVO selectPayment(String pay_no) {
		PaymentVO vo = null;
		
		try {
			vo = (PaymentVO) client.queryForObject("payment.selectPayment", pay_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertPayment(PaymentVO vo) {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("payment.insertPayment", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updatePayment(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("payment.updatePayment", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updatePayment2(PaymentVO vo) {
		int result = 0;
		
		try {
			result = client.update("payment.updatePayment2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deletePayment(String pay_no) {
		int result = 0;
		
		try {
			result = client.delete("payment.deletePayment", pay_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String selectPayNo(String mem_id) {
		String res = null;
		
		try {
			res = (String)client.queryForObject("payment.selectPayNo", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertPayNo() {
		Object obj = null;
		int result = 0;
		
		try {
			obj = client.insert("payment.insertPayNo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public String selectNewPayNo() {
		String res = null;
		
		try {
			res = (String)client.queryForObject("payment.selectNewPayNo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}


}
