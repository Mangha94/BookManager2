package Book.MemberShip;

import Book.BookAPL.BookCenter;
import Book.InputMenu;
import Book.Inputclass;
import Book.Member.MemberCenter;
import Book.Member.Members;

import java.lang.reflect.Member;
import java.util.List;

/**
 * 회원이나 관리자 확인
 */
public class Membership {

    MemberCenter mc;
    BookCenter bc;

    public void Membership(MemberCenter mc){
        this.mc=mc;
    }
    public void Membership(BookCenter bc){
        this.bc=bc;
    }

    /**
     * 회원 인증
     * 아이디를 입력받아서 체크 맞으면 다음 과정으로 넘어가게 한다.
     */
    public boolean MemberCheck() {
        System.out.println("아이디를 입력해주세요");
        Inputclass in=new Inputclass();
        InputMenu inputMenu=in.getInputMenu();
        List<Members> memberCheck= mc.findByID(inputMenu.getMenuCode());
        if(memberCheck.size()==1) {
            System.out.println("로그인되었습니다.");
            System.out.println("대여 가능 목록");
            System.out.println(bc.getBooks());

            BorrowBook bb=new BorrowBook();
            bb.borrowBook();
        }

        else
            System.out.println("등록된 회원이 아닙니다.");

        return false;
    }
}
