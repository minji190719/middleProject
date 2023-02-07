package kr.or.ddit.vo;

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.service.iQnaService;

public class Pagin {
	private iQnaService service;
	private final static int pageCount = 5;
	private int blockStartNum = 0;
	private int blockLastNum = 0;
	private int lastPageNum = 0;
	public int getBlockStartNum() {
		return blockStartNum;
	}
	public void setBlockStartNum(int blockStartNum) {
		this.blockStartNum = blockStartNum;
	}
	public int getBlockLastNum() {
		return blockLastNum;
	}
	public void setBlockLastNum(int blockLastNum) {
		this.blockLastNum = blockLastNum;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	
	//block 생성 --> block이란 1~5page가 속해있는 그룹을 의미. 1~5 , 6~10
	//현재 페이지가 속한 block의 시작번호, 끝번호를 계산
	public void makeBlock(int curPage) {
		int blockNum = 0;
		
		blockNum = (int)Math.floor((curPage-1)/pageCount);
		blockStartNum = (pageCount * blockNum) + 1;
		blockLastNum = blockStartNum + (pageCount - 1);
	}
	
	//총 페이지의 마지막번호
	public void makeLastPageNum() {
		QnaVO vo = new QnaVO();
		int total = service.selectAllCount();
		
		if (total % pageCount == 0) {
			lastPageNum = (int)Math.floor(total/pageCount);
		} else {
			lastPageNum = (int)Math.floor(total/pageCount) + 1;
		}
		
	}
	
	//검색을 했을 때 총 페이지의 마지막 번호
//	public void makeLastPageNum(String kwd) {
//		QnaVO vo = new QnaVO();
//		int total = service.selectAllCount(kwd);
//		
//		if (total % pageCount == 0) {
//			lastPageNum = (int)Math.floor(total/pageCount);
//		} else {
//			lastPageNum = (int)Math.floor(total/pageCount) + 1;
//		}
//	}

}
