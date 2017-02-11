package Book.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 관련 장부 생성 클래스
 * 추가 메소드,찾기 메소드
 */
public class MemberCenter {

    private List<Members> members;

    public MemberCenter()
    {
        members = new ArrayList<>();
    }

    public List<Members> getMembers()
    {
        List<Members> copyMembers=  new ArrayList<>(members);
        return copyMembers;
    }

    public void addMembers(Members member)

    {
        members.add(member);
    }

    public List<Members> search(String element,String keyWord)
    {
        List<Members> findList=new ArrayList<>();
        for(Members listMember:members)
        {
            String searchKey="";
            if(element.equals("id"))
                searchKey=listMember.getId();
            if(element.equals("name"))
                searchKey=listMember.getName();
            if(element.equals("phonnumber"))
                searchKey=listMember.getPhonnumber();
            if(searchKey.equals(keyWord))
                findList.add(listMember);
        }
        return findList;
    }

    public List<Members>findByID(String id) {return search("id",id);}
    public List<Members>findByName(String name) {return search("name",name);}
    public List<Members>findByPhonNumber(String phonnumber) {return search("phonnumber",phonnumber);}

    public boolean findIdErr (String id)
    {
        for (Members member : members)
        {
            if (member.getId ().equals (id))
                return false;
        }

        return true;
    }
    public boolean MemberRemove(String id)
    {
        Members remove = (Members) findByID(id);
        if(remove != null)
        {
            members.remove(remove);
            return true;
        }
        else
            return false;
    }
}
