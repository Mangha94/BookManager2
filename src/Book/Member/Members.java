package Book.Member;

import java.util.Date;

/**
 * Created by ttinfo on 2017-02-08.
 */
public class Members {
    private String name;
    private String memberId;
    private String phonnumber;
    private String birthday;
    private Date regDate;
    private String log;
    private String pw;

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Members(){}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getMemberId() {return memberId;}

    public void setMemberId(String memberId) {this.memberId = memberId;}

    public String getPhonnumber() {return phonnumber;}

    public void setPhonnumber(String phonnumber) {this.phonnumber = phonnumber;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public Date getRegDate() {return regDate;}

    public void setRegDate(Date regDate) {this.regDate = regDate;}

    public void setLog(String log){this.log=log;}

    public String toString()
    {
        return "["
                +log
                +"이름 : " +name
                +" 아이디 : "+memberId
                +" 연락처 : "+phonnumber
                +" 생년월일 : "+birthday
                  +" 등록일 : "+regDate
                +"\n]";
    }


}
