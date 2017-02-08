package Book.Member;

import java.util.List;

/**
 * 회원 찾기 클래스
 */
public class MemberSearch {

        Members members=new Members();
        MemberCenter bc=new MemberCenter();

        public List<Members> findByID (String id)
        {
            for (Members member : bc.members) {
                if (member.getId().equals(id))
                    return bc.members;
            }

            System.out.println("이미 존재하는 아이디 입니다");
            return null;

    }
}
