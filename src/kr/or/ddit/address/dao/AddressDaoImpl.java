package kr.or.ddit.address.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.AddressVO;

public class AddressDaoImpl implements IAddressDao {
	private SqlMapClient client;
	private static AddressDaoImpl dao;
	
	private AddressDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static AddressDaoImpl getInstance() {
		if (dao == null) dao = new AddressDaoImpl();
		return dao;
	}
	
	@Override
	public List<AddressVO> selectAllAddress() {
		
		List<AddressVO> list= null;
		
		try {
			list = client.queryForList("address.selectAllAddress");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AddressVO selectAddress(String mem_id) {
		AddressVO vo = null;
		
		try {
			vo = (AddressVO)client.queryForObject("address.selectAddress", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public int insertAddress(AddressVO vo) {
		
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("address.insertAddress", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(obj ==null) {
			result = 1;
		}
		return result;
	}

	@Override
	public int updateAddress(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("address.updateAddress", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateAddress2(AddressVO vo) {
		int result = 0;
		
		try {
			result = client.update("address.updateAddress2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return result;
	}

	@Override
	public int deleteAddress(String addr_no) {

		int result = 0;
		
		try {
			result = client.delete("address.deleteAddress",addr_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


}
