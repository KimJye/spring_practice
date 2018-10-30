package edu.spring.ex02.pageutil;

// 게시글 테이블 아래에 페이지 번호들을 만들어 주기 위한 클래스
public class PageNumberMaker {
	// 몇번째 페이지를 보고 있는지, 한  페이지에 몇개를 볼 것인지에 대한 기준
	private PaginationCriteria criteria;

	// 게시글 전체 갯수
	private int totalCount;

	// 페이지 번호를 몇개씩 보여줄 것인지
	private int numsOfLinks;

	// 화면에 보여지는 시작 페이지 번호
	private int startPage;
	// 화면에 보여지는 끝 페이지 번호
	private int endPage;
	// 이전/다음 링크가 필요한 지
	private boolean prev;
	private boolean next;
	
	public PageNumberMaker() {
		this.numsOfLinks = 10;
	}

	public PaginationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PaginationCriteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNumsOfLinks() {
		return numsOfLinks;
	}

	public void setNumsOfLinks(int numsOfLinks) {
		this.numsOfLinks = numsOfLinks;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setPageMakerData() {
		// 전체 페이지 갯수
		int totalPageNum = (int)
				Math.ceil((double) totalCount / criteria.getNumsPerPage());
		
		int temp = (int)
				(Math.ceil((double) criteria.getPage() / numsOfLinks)) * numsOfLinks;
		if (temp > totalPageNum) {
			endPage = totalPageNum;
		} else {
			endPage = temp;
		}
		
		startPage = ((endPage - 1) / numsOfLinks) * numsOfLinks + 1;
		
		if (startPage == 1) {
			prev = false;
		} else {
			prev = true;
		}
		
		if (endPage * criteria.getNumsPerPage() >= totalCount) {
			next = false;
		} else {
			next = true;
		}
	}
	
} // end class PageNumberMaker




















