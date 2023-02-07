package kr.or.ddit.fileinfo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileinfo.dao.FileInfoDaoImpl;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {
	
	private FileInfoDaoImpl dao;
	
	private static FileInfoServiceImpl service;
	
	private FileInfoServiceImpl() {
		dao = FileInfoDaoImpl.getInstance();
	}
	
	public static FileInfoServiceImpl getInstance() {
		if(service ==null) {
			service = new FileInfoServiceImpl();
		}
		return service;
	}
	

	@Override
	public List<FileInfoVO> selectAllFileInfo() {
		return dao.selectAllFileInfo();
	}

	@Override
	public FileInfoVO selectFileInfo(String file_no) {
		return dao.selectFileInfo(file_no);
	}

	@Override
	public int insertFileInfo(FileInfoVO vo) {
		return dao.insertFileInfo(vo);
	}

	@Override
	public int updateFileInfo(Map<String, Object> map) {
		return dao.updateFileInfo(map);
	}
	
	@Override
	public int updateFileInfo2(FileInfoVO vo) {
		return dao.updateFileInfo2(vo);
	}

	@Override
	public int deleteFileInfo(String file_no) {
		return dao.deleteFileInfo(file_no);
	}


	
}
