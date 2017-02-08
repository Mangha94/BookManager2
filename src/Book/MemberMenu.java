package Book;

import Book.Member.MemberInput;

/**
 * 맴버 관련 클래스 연결 클래스
 */
public class MemberMenu {

    public void membermenu() {

        while (true)
        {
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
                MemberInput mi=new MemberInput();
                mi.input();
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                //todo 회원찾기 클래스
            }
            else if (("3").equals(inputMenu.getMenuCode()))
            {
                //todo 회원삭제 클래스
            }
            else if (("4").equals(inputMenu.getMenuCode()))
            {
                //todo 회원정보 클래스
            }
        }
    }
}
