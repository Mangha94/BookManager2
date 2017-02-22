package Book.Member;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 관련 장부 생성 클래스
 * 추가 메소드,찾기 메소드
 */
public class MemberCenter {

    //todo 싱글턴(인스턴스)
    private List<Members> memberlist;

    public MemberCenter() {
        memberlist = new ArrayList<>();
    }

    public List<Members> getMembers() {
        List<Members> copyMembers = new ArrayList<>(memberlist);
        return copyMembers;
    }

    public void addMembers(Members member)

    {
        MemberLog ml = new MemberLog();
        ml.memberLog(member);
        memberlist.add(member);

    }

    public List<Members> search(String element, String keyWord) {
        List<Members> findList = new ArrayList<>();
        for (Members listMember : memberlist) {
            //todo id중복체크
            String searchKey = "";
            if (element.equals("id"))
                searchKey = listMember.getId();
            if (element.equals("name"))
                searchKey = listMember.getName();
            if (element.equals("phonnumber"))
                searchKey = listMember.getPhonnumber();
            if (searchKey.equals(keyWord))
                findList.add(listMember);
        }
        return findList;
    }

    public List<Members> findByID(String id) {
        return search("id", id);
    }

    public List<Members> findByName(String name) {
        return search("name", name);
    }

    public List<Members> findByPhonNumber(String phonnumber) {
        return search("phonnumber", phonnumber);
    }

    public boolean Login(String id) {
        for (Members member : memberlist) {
            if (id.equals(member.getId()))
                return true;
        }

        return true;
    }

    public boolean remove(String id) {
        for (Members member : memberlist) {
            if (id.equals(member.getId())) {
                memberlist.remove(member);
                return true;
            }
        }
        return false;
    }
}
