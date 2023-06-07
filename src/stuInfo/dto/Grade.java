package stuInfo.dto;

/**
 * 描述：
 * 作者：小陶不慌张
 * 文件：Grade
 * 日期：2023/3/2 13:06
 */

public class Grade {
    private String snum;
    private String sname;
    private String cid;
    private String cname;
    private int score;

    public Grade() {
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getSnum() {
        return snum;
    }

    public Grade(String snum, String sname, String cid, String cname, int score) {
        this.snum = snum;
        this.sname = sname;
        this.cid = cid;
        this.cname = cname;
        this.score = score;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", cid='" + cid + '\'' +
                ", score=" + score +
                '}';

    }
}
