package kr.or.ddit.fileinfo.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileInfoVO;

public interface IFileInfoDao {
	
	public List<FileInfoVO> selectAllFileInfo();
	
	public FileInfoVO selectFileInfo(String file_no);
	
	public int insertFileInfo(FileInfoVO vo);
	
	public int updateFileInfo(Map<String, Object> map);
	
	public int updateFileInfo2(FileInfoVO vo);
	
	public int deleteFileInfo(String file_no);

}
