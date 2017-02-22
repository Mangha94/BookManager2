package Book.Member;

import java.util.Date;

/**
 * Created by ttinfo on 2017-02-08.
 */
public class Members {
    private String name;
    private String id;
    private String phonnumber;
    private String birthday;
    private Date regDate;
    private String log;

    public Members(){}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

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
                +" 아이디 : "+id
                +" 연락처 : "+phonnumber
                +" 생년월일 "+birthday
                +"\n]";
    }


}
