package net.mds.forum.board;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PageNation implements Serializable{
	private PageVO pageVO = new PageVO();
	@Value("${article.pageSize}")
	private int pageSize;
	@Value("${article.blockSize}")
	private int blockSize;
	private long pg;
	private long totalCount;
	private long pageCount;
	private long StartPage;
	private long endPage;
	private StringBuffer display;
	
	private List<ArticleVO> list;
	
	@Autowired
	private BoardService boardService;

	public void process(int boa_no, long pg, String boa_url) throws Exception {
		this.pg = pg;
		pageVO.setStartnum((pg-1) * pageSize + 1);
		pageVO.setEndnum(pg * pageSize);
		pageVO.setBoa_no(boa_no);
		
		setList(boardService.getArticleList(pageVO));
		setTotalCount(boardService.getTotalCount(boa_no));
		setPageCount((long)Math.ceil((double)getTotalCount() / getPageSize()));
		setStartPage((pg - 1) / getBlockSize() * getBlockSize() + 1);
		setEndPage((pg - 1) / getBlockSize() * getBlockSize() + getBlockSize());
		if (getEndPage() > getPageCount()) {
			setEndPage(getPageCount());
		}
		
		display = new StringBuffer();
		display.append("<nav class='pg_wrap'>");
		display.append("<span class='pg'>");
		
		if(getStartPage() == 1) {
			
		}else if (getPg() > 0) {
			display.append("<a href='/forum/board/"+boa_url+"?pg=1' class='pg_page pg_start'>첫페이지</a>");
		}
		
		if(getStartPage() == 1) {
			//display.append("[이전 블럭]");
		} else {
			display.append("<a href='/forum/board/"+boa_url+"?pg=" + (getStartPage() - 1) + "' class='pg_page pg_prev'>이전</a>");
		}
		
		for(long p=getStartPage(); p<=getEndPage(); p++){
			if(p == getPg()) {
				display.append("<span class='sound_only'>열린</span>");
				display.append("<strong class='pg_current'>" + p + "</strong>");
				display.append("<span class='sound_only'>페이지</span>");
			} else {
				display.append(" <a href='/forum/board/"+boa_url+"?pg=" + p + "' class='pg_page'>" + p + "<span class='sound_only'>페이지</span></a>");
			}
		}
		
		if(getEndPage() == getPageCount()) {
			//display.append("[다음 블럭]");
		} else {
			display.append("<a href='/forum/board/"+boa_url+"?pg=" + (getEndPage() + 1) + "' class='pg_page pg_next'>다음</a>");
		}
		
		if(getEndPage() == getPageCount()) {
			
		}else if(getPg() > 0) {
			display.append("<a href='/forum/board/"+boa_url+"?pg=" + getPageCount() + "' class='pg_page pg_end'>끝페이지</a>");
		}
		
		display.append("</span>");
		display.append("</nav>");
	}
	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public long getPg() {
		return pg;
	}

	public void setPg(long pg) {
		this.pg = pg;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getStartPage() {
		return StartPage;
	}

	public void setStartPage(long startPage) {
		StartPage = startPage;
	}

	public long getEndPage() {
		return endPage;
	}

	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}

	public StringBuffer getDisplay() {
		return display;
	}

	public void setDisplay(StringBuffer display) {
		this.display = display;
	}

	public List<ArticleVO> getList() {
		return list;
	}

	public void setList(List<ArticleVO> list) {
		this.list = list;
	}

	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String toString() {
		return "PageNation [pageVO=" + pageVO + ", pageSize=" + pageSize + ", blockSize=" + blockSize + ", pg=" + pg
				+ ", totalCount=" + totalCount + ", pageCount=" + pageCount + ", StartPage=" + StartPage + ", endPage="
				+ endPage + ", display=" + display + ", list=" + list + ", boardService=" + boardService + "]";
	}
	
	
}
