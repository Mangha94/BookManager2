package Book;

import Book.BookAPL.BookCenter;
import Book.BookAPL.BookSearch;
import Book.Borrow.BorrowBook;
import Book.Borrow.BorrowCenter;
import Book.Borrow.MoneyCenter;
import Book.Borrow.ReturnBook;
import Book.Login.LoginCenter;
import Book.Login.LoginInfo;

/**
 * Created by ttinfo on 2017-02-22.
 */
public class BookMenuForUser {
    BookCenter bc;
    LoginCenter lc;
    BorrowCenter br;
    MoneyCenter moneyCenter;
    public BookMenuForUser(BookCenter bc,LoginCenter lc){
        this.bc=bc;
        this.lc=lc;
        br=new BorrowCenter(bc,lc);
    }

    public void bookMenuForUser()
    {
        while(true)
        {
            System.out.println("============================");
            System.out.println("1. 도서 대여");
            System.out.println("2. 도서 찾기");
            System.out.println("3. 빌린 목록");
            System.out.println("4. 반납 하기");

            Inputclass in=new Inputclass();

            InputMenu inputMenu=in.getInputMenu();

            //q,Q,x,X를 누르면 뒤로가기
            if(inputMenu.isBack ())
                break;

            if (("1").equals(inputMenu.getMenuCode()))
            {
                BorrowBook bb=new BorrowBook(bc,lc,br);
                bb.borrowBooks();
            }
            else if(("2").equals(inputMenu.getMenuCode()))
            {
                BookSearch booksearch=new BookSearch(bc);
                booksearch.search();
            }else if(("3").equals(inputMenu.getMenuCode()))
            {
                System.out.println(br.getUserBorrowList());
            }else if(("4").equals(inputMenu.getMenuCode()))
            {
                ReturnBook returnBook=new ReturnBook(br,lc);
                returnBook.returnBook();
            }
        }
    }
}
