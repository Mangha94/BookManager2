package Book.Borrow;

import Book.BookAPL.BookCenter;
import Book.InputMenu;
import Book.Inputclass;

/**
 * 책 빌리기 ui
 */
public class BorrowBooks {
    BookCenter bc;
    BorrowCenter br;
    public BorrowBooks(BookCenter bc){
        this.bc=bc;
        br=new BorrowCenter(bc);
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
