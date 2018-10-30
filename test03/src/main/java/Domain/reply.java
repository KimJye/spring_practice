package Domain;

public class reply {

    private int bno;
    private int rno;
    private String replier;
    private String rcontent;
    // 네 개 변수 생성 후 생성자와 getter setter 만들어 주세요.
    // 그리고 바로 DB 설계

    public reply() {}

    public reply(String replier, String rcontent) {
        this.replier = replier;
        this.rcontent = rcontent;
    }

    public reply(int bno, int rno, String replier, String rcontent) {
        this.bno = bno;
        this.rno = rno;
        this.replier = replier;
        this.rcontent = rcontent;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }
}
