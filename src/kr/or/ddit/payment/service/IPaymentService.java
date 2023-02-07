package kr.or.ddit.payment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PaymentVO;

public interface IPaymentService {
	public List<PaymentVO> selectAllPayment();
	
	public PaymentVO selectPayment(String pay_no);

	public String selectPayNo(String mem_id);
	
	public int insertPayment(PaymentVO vo);
	
	public int updatePayment(Map<String, Object> map);
	
	public int updatePayment2(PaymentVO vo);
	
	public int deletePayment(String pay_no);
	
	public int insertPayNo();
	
	public String selectNewPayNo();
}
