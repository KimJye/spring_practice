package Domain;

public class board {

    private int bno;
    private String userid;
    private String title;
    private String content;

    public board() {
    }

    public board(int bno, String userid, String title, String content) {
        this.bno = bno;
        this.userid = userid;
        this.title = title;
        this.content = content;
    }

    public board(String userid, String title, String content) {
        this.userid = userid;
        this.title = title;
        this.content = content;

    }


    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
