package Book.Member;

/**
 * Created by ttinfo on 2017-02-08.
 */
public class Members {
    String name;
    String id;
    String phonnumber;
    String birthday;

    public Members(){}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getPhonnumber() {return phonnumber;}

    public void setPhonnumber(String phonnumber) {this.phonnumber = phonnumber;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public String toString()
    {
        return "["
                +"이름 : " +name
                +" 아이디 : "+id
                +" 연락처 : "+phonnumber
                +" 생년월일 "+birthday
                +"]";
    }


}
