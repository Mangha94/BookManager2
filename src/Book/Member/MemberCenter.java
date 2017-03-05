package Book.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Book.DB.BookManageDB;

/**
 * 회원 관련 장부 생성 클래스
 * 추가 메소드,찾기 메소드
 */
public class MemberCenter {

    //todo 싱글턴(인스턴스)
    private List<Members> memberlist;

    BookManageDB bookManageDB = new BookManageDB ();

    MemberLog ml;

    public MemberCenter() {
        memberlist = new ArrayList<>();
        ml = new MemberLog(this);
    }

    public List<Members> getMembers() {

        List<Members> list = new ArrayList<>();
        try
        {
            Connection conn = bookManageDB.makeConnect ();

            String sql = "select * from members";                        // sql 쿼리
            PreparedStatement pStmt = conn.prepareStatement (sql);// prepareStatement에서 해당 sql을 미리 컴파일한다.
            // pStmt.setString (1, "test");

            ResultSet rs = pStmt.executeQuery ();// 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.

            while (rs.next ())
            {                                                        // 결과를 한 행씩 돌아가면서 가져온다.
                list.add (new Members (rs));
            }

            rs.close ();

            conn.close ();

        }
        catch(Exception ex)
        {
            ex.printStackTrace ();
        }


        return list;
    }

    public void addMembers(Members member)

    {
        ml.memberLog(member);

        try
        {
            Connection conn = bookManageDB.makeConnect ();

            String sql = "INSERT INTO members (memberId,phonnumber,birthday,regDate,pw,memberNum, name) VALUES (? ,? ,? ,? ,? , ?, ?)";        // sql 쿼리
            PreparedStatement pstmt = conn.prepareStatement(sql);                          // prepareStatement에서 해당 sql을 미리 컴파일한다.
            pstmt.setString(1,member.getMemberId ());
            pstmt.setString(2,member.getPhonnumber ());
            pstmt.setString(3,member.getBirthday ());
            pstmt.setDate (4, new java.sql.Date (member.getRegDate ().getTime ()));    // 현재 날짜와 시간

            pstmt.setString(5, member.getPw ());
            pstmt.setString(6, member.getMemberNum ());
            pstmt.setString(7, member.getName ());

            pstmt.executeUpdate();                                        // 쿼리를 실행한다.

            conn.close ();

        }
        catch(Exception ex)
        {
            ex.printStackTrace ();
        }
    }

    public List<Members> search(String element, String keyWord) {
        List<Members> findList = new ArrayList<>();
        for (Members listMember : memberlist) {
            // id중복체크
            String searchKey = "";
            if (element.equals("memberId"))
                searchKey = listMember.getMemberId();
            if (element.equals("name"))
                searchKey = listMember.getName();
            if (element.equals("phonnumber"))
                searchKey = listMember.getPhonnumber();
            if (searchKey.equals(keyWord))
                findList.add(listMember);
        }
        return findList;
    }

    /**
     * 아이디로 회원을 찾는다.
     * @param memberId 회원 아이디
     * @return 회원을 찾았다면 회원 객체를 리턴하고, 찾지 못했다면 null 을 리턴한다.
     */
    public Members findByMemberID(String memberId)
    {
        Members returnVal = null;

        try
        {
            Connection conn = bookManageDB.makeConnect ();

            String sql = "select * from members where memberId=?";                        // sql 쿼리
            PreparedStatement pStmt = conn.prepareStatement (sql);// prepareStatement에서 해당 sql을 미리 컴파일한다.
            pStmt.setString (1, memberId);

            ResultSet rs = pStmt.executeQuery ();// 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.

            if (rs.next ())
            {                                                        // 결과를 한 행씩 돌아가면서 가져온다.
                returnVal = new Members (rs);
            }

            rs.close ();

            conn.close ();

        }
        catch(Exception ex)
        {
            ex.printStackTrace ();
        }

        return returnVal;
    }

    public List<Members> findByName(String name) {
        return search("name", name);
    }

    public List<Members> findByPhonNumber(String phonnumber) {
        return search("phonnumber", phonnumber);
    }

    public boolean remove(String memberId)
    {
        try
        {
            Connection conn = bookManageDB.makeConnect ();

            String sql = "DELETE FROM members WHERE memberId=?";        // sql 쿼리
            PreparedStatement pstmt = conn.prepareStatement(sql);                          // prepareStatement에서 해당 sql을 미리 컴파일한다.
            pstmt.setString(1,memberId);

            pstmt.executeUpdate();                                        // 쿼리를 실행한다.

            conn.close ();

            return true;

        }
        catch(Exception ex)
        {
            ex.printStackTrace ();

            return false;
        }

    }
}
