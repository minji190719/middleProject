package kr.or.ddit.delivery.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.DeliveryVO;

public class DeliveryDaoImpl implements IDeliveryDao{
	
	private SqlMapClient client;
	
	private static DeliveryDaoImpl dao;
	
	private DeliveryDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
		
	}
	
	public static DeliveryDaoImpl getInstance() {
		if(dao ==null) dao = new DeliveryDaoImpl();
		return dao;
	}
	

	@Override
	public List<DeliveryVO> selectAllDelivery() {
		List<DeliveryVO> list = null;
		
		try {
			list = client.queryForList("delivery.selectDelivery");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public DeliveryVO selectDelivery(String pay_no) {
		DeliveryVO vo = null;
		
		try {
			vo = (DeliveryVO) client.queryForObject("delivery.selectDelivery", pay_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return vo;
	}

	@Override
	public int insertDelivery(DeliveryVO vo) {

		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("delivery.insertDelivery", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	
	}

	@Override
	public int updateDelivery(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("delivery.updateDelivery", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateDelivery2(DeliveryVO vo) {
		int result = 0;
		
		try {
			result = client.update("delivery.updateDelivery2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteDelivery(String deli_no) {
		int result = 0;
		
		try {
			result = client.delete("delivery.deleteDelivery", deli_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
