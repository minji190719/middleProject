package kr.or.ddit.delivery.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.delivery.dao.DeliveryDaoImpl;
import kr.or.ddit.vo.DeliveryVO;

public class DeliveryServiceImpl implements IDeliveryService{

	private DeliveryDaoImpl dao;
	
	private static DeliveryServiceImpl service;
	
	private DeliveryServiceImpl() {
		dao = DeliveryDaoImpl.getInstance();
	}
	
	public static DeliveryServiceImpl getInstance() {
		if(service == null) service = new DeliveryServiceImpl();
		return service;
	}
	
	
	@Override
	public List<DeliveryVO> selectAllDelivery() {
		return dao.selectAllDelivery();
	}

	@Override
	public DeliveryVO selectDelivery(String pay_no) {
		return dao.selectDelivery(pay_no);
	}

	@Override
	public int insertDelivery(DeliveryVO vo) {
		return dao.insertDelivery(vo);
	}

	@Override
	public int updateDelivery(Map<String, Object> map) {
		return dao.updateDelivery(map);
	}
	
	@Override
	public int updateDelivery2(DeliveryVO vo) {
		return dao.updateDelivery2(vo);
	}

	@Override
	public int deleteDelivery(String deli_no) {
		return dao.deleteDelivery(deli_no);
	}


}
