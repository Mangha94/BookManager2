package Book.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 관련 장부 생성 클래스
 */
public class MemberCenter {
    List<Members>membercenter =new ArrayList<Members>();

    public List<Members> members;

    public MemberCenter()
    {
        members = new ArrayList<>();
    }

}
