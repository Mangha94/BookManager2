package Book.Borrow;

import Book.BookAPL.BookCenter;
import Book.InputMenu;
import Book.Inputclass;
import Book.Login.LoginCenter;
import Book.Login.LoginInfo;

/**
 * 책 빌리기 ui
 */
public class BorrowBook {
    BookCenter bc;
    BorrowCenter br;
    LoginCenter lc;
    public BorrowBook(BookCenter bc,LoginCenter lc,BorrowCenter br){
        this.bc=bc;
        this.lc=lc;
        this.br=br;
    }
    Inputclass in=new Inputclass();

    public void borrowBooks(){
        System.out.println("대여 관리 UI");
        System.out.println("대여가능 목록");
        System.out.println("============================");
        System.out.println(bc.getBooks());
        System.out.println("빌릴책 아이디를 입력해주세요");

        InputMenu inputMenu1=in.getInputMenu();
        br.borrow(inputMenu1.getMenuCode());
        System.out.println(bc.findById(inputMenu1.getMenuCode())+"를 대여완료하였습니다.");
    }
}
