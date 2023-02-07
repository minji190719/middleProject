package kr.or.ddit.payment.service;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.payment.dao.IPaymentDao;
import kr.or.ddit.payment.dao.PaymentDaoImpl;
import kr.or.ddit.vo.PaymentVO;

public class PaymentServiceImpl implements IPaymentService {
	private IPaymentDao dao;
	private static PaymentServiceImpl service;
	
	private PaymentServiceImpl() {
		dao = PaymentDaoImpl.getInstance();
	}
	
	public static PaymentServiceImpl getInstance() {
		if (service == null) service = new PaymentServiceImpl();
		return service;
	}
	

	@Override
	public List<PaymentVO> selectAllPayment() {
		return dao.selectAllPayment();
	}

	@Override
	public PaymentVO selectPayment(String pay_no) {
		return dao.selectPayment(pay_no);
	}

	@Override
	public int insertPayment(PaymentVO vo) {
		return dao.insertPayment(vo);
	}

	@Override
	public int updatePayment(Map<String, Object> map) {
		return dao.updatePayment(map);
	}
	
	@Override
	public int updatePayment2(PaymentVO vo) {
		return dao.updatePayment2(vo);
	}

	@Override
	public int deletePayment(String pay_no) {
		return dao.deletePayment(pay_no);
	}

	@Override
	public String selectPayNo(String mem_id) {
		// TODO Auto-generated method stub
		return dao.selectPayNo(mem_id);
	}

	@Override
	public int insertPayNo() {
		// TODO Auto-generated method stub
		return dao.insertPayNo();
	}

	@Override
	public String selectNewPayNo() {
		// TODO Auto-generated method stub
		return dao.selectNewPayNo();
	}


}
