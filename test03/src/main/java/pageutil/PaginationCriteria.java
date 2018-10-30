package pageutil;

public class PaginationCriteria {
    private int page; // 현재 보고 있는 페이지
    private int numsPerPage; // 한 페이지에 보여줄 게시글 갯수

    public PaginationCriteria(){
        this.page = 1;
        this.numsPerPage = 10;
    }

    public PaginationCriteria(int page, int numsPerPage) {
        this.page = page;
        this.numsPerPage = numsPerPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumsPerPage() {
        return numsPerPage;
    }

    public void setNumsPerPage(int numsPerPage) {
        this.numsPerPage = numsPerPage;
    }

    public int getStart(){
        return (page -1) * numsPerPage + 1;
    }

    public int getEnd() {
        return page * numsPerPage;
    }
}
