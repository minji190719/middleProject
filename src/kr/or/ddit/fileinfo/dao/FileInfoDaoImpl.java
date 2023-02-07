package kr.or.ddit.fileinfo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.vo.Acc_StockVO;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoDaoImpl implements IFileInfoDao {

	private SqlMapClient client;
	
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
		
	}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao ==null) dao = new FileInfoDaoImpl();
		
		return dao;
	}

	@Override
	public List<FileInfoVO> selectAllFileInfo() {
		List<FileInfoVO> list = null;
		
		try {
			list = client.queryForList("fileInfo.selectAllFileInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public FileInfoVO selectFileInfo(String file_no) {
		FileInfoVO vo = null;
		
		try {
			vo = (FileInfoVO) client.queryForObject("fileInfo.selectFileInfo", file_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return vo;
	}

	@Override
	public int insertFileInfo(FileInfoVO vo) {
		int result = 0;
		Object obj = null;
		
		try {
			obj = client.insert("fileInfo.insertFileInfo", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (obj == null) result = 1;
		
		return result;
	}

	@Override
	public int updateFileInfo(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = client.update("fileInfo.updateFileInfo", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateFileInfo2(FileInfoVO vo) {
		int result = 0;
		
		try {
			result = client.update("fileInfo.updateFileInfo2", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteFileInfo(String file_no) {
		int result = 0;
		
		try {
			result = client.delete("fileInfo.deleteFileInfo", file_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	
	

}
