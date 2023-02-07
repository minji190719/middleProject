package kr.or.ddit.delivery.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DeliveryVO;

public interface IDeliveryService {

	
	public List<DeliveryVO> selectAllDelivery();
	
	public DeliveryVO selectDelivery(String pay_no);
	
	public int insertDelivery(DeliveryVO vo);
	
	public int updateDelivery(Map<String, Object> map);
	
	public int updateDelivery2(DeliveryVO vo);
	
	public int deleteDelivery(String deli_no);
	
	
	
	
}
