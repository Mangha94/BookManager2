package Book;

import Book.BookAPL.BookCenter;
import Book.BookAPL.BookInput;
import Book.BookAPL.BookRemove;
import Book.BookAPL.BookSearch;
import Book.Borrow.BorrowCenter;
import Book.Login.LoginCenter;

/**
 * 책 관련 클래스 연결 클래스
 */
public class BookMenu
{
    BookCenter bc;
    LoginCenter lc;
    public BookMenu(BookCenter bc,LoginCenter lc){
        this.bc=bc;
        this.lc=lc;
    }


    public void bookMenu()
    {
        while(true)
        {
            System.out.println(bc.getBooks());
            System.out.println("============================");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 찾기");
            System.out.println("4. 총 대여목록");

            Inputclass in=new Inputclass();

            InputMenu inputMenu=in.getInputMenu();

            //q,Q,x,X를 누르면 뒤로가기
            if(inputMenu.isBack ())
                break;

            if (("1").equals(inputMenu.getMenuCode()))
            {
                System.out.println("추가 할 책을 입력해주세요.(책 이름)");
                BookInput bookInput=new BookInput(bc);
                bookInput.input();
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                BookRemove bookRemove=new BookRemove(bc);
                bookRemove.Remove();
            }
            else if(("3").equals(inputMenu.getMenuCode()))
            {
                BookSearch booksearch=new BookSearch(bc);
                booksearch.search();
            }else if(("4").equals(inputMenu.getMenuCode()))
            {
                BorrowCenter br=new BorrowCenter(bc,lc);
                br.getBorrowList();
            }
        }
    }
}
