package kr.or.ddit.address.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.address.dao.AddressDaoImpl;
import kr.or.ddit.address.dao.IAddressDao;
import kr.or.ddit.vo.AddressVO;

public class AddressServiceImpl implements IAddressService {
	private IAddressDao dao;
	private static AddressServiceImpl service;
	
	private AddressServiceImpl() {
		dao = AddressDaoImpl.getInstance();
	}
	
	public static AddressServiceImpl getInstance() {
		if (service == null) service = new AddressServiceImpl();
		return service;
	}

	@Override
	public List<AddressVO> selectAllAddress() {
		return dao.selectAllAddress();
	}

	@Override
	public AddressVO selectAddress(String mem_id) {
		return dao.selectAddress(mem_id);
	}

	@Override
	public int insertAddress(AddressVO vo) {
		return dao.insertAddress(vo);
	}

	@Override
	public int updateAddress(Map<String, Object> map) {
		return dao.updateAddress(map);
	}
	
	@Override
	public int updateAddress2(AddressVO vo) {
		return dao.updateAddress2(vo);
	}

	@Override
	public int deleteAddress(String addr_no) {
		return dao.deleteAddress(addr_no);
	}


}
