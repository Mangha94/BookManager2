package Book;

import Book.Member.MemberCenter;
import Book.Member.MemberInput;
import Book.Member.MemberRemove;
import Book.Member.MemberSearch;

/**
 * 맴버 관련 클래스 연결 클래스
 */
public class MemberMenu {

    MemberCenter mc;
    public MemberMenu(MemberCenter mc){this.mc=mc;}

    public void membermenu() {

        while (true)
        {
            System.out.println(mc.getMembers());
            System.out.println("============================");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 정보");

            Inputclass in = new Inputclass();

            InputMenu inputMenu = in.getInputMenu();

            //q,Q,x,X를 누르면 뒤로가기
            if (inputMenu.isBack())
                break;

            if (("1").equals(inputMenu.getMenuCode()))
            {
                MemberInput mi=new MemberInput(mc);
                mi.input();
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                MemberSearch ms=new MemberSearch(mc);
                ms.Search();
            }
            else if (("3").equals(inputMenu.getMenuCode()))
            {
                MemberRemove mr=new MemberRemove(mc);
                mr.Remove();
            }
            else if (("4").equals(inputMenu.getMenuCode()))
            {
                //todo 회원정보 클래스
            }
        }
    }
}
