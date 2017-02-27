package Book;

import Book.BookAPL.BookCenter;
import Book.BookAPL.BookSearch;
import Book.Borrow.BorrowBooks;
import Book.Borrow.BorrowCenter;

/**
 * Created by ttinfo on 2017-02-22.
 */
public class BookMenuForUser {
    BookCenter bc;
    public BookMenuForUser(BookCenter bc){
        this.bc=bc;
    }

    public void bookMenuForUser()
    {
        while(true)
        {
            System.out.println("============================");
            System.out.println("1. 도서 대여");
            System.out.println("2. 도서 찾기");
            System.out.println("3. 빌린 목록");

            Inputclass in=new Inputclass();

            InputMenu inputMenu=in.getInputMenu();

            //q,Q,x,X를 누르면 뒤로가기
            if(inputMenu.isBack ())
                break;

            if (("1").equals(inputMenu.getMenuCode()))
            {
                //todo 책 대여 메소드
                BorrowBooks bb=new BorrowBooks(bc);
                bb.borrowBooks();
            }
            else if(("2").equals(inputMenu.getMenuCode()))
            {
                BookSearch booksearch=new BookSearch(bc);
                booksearch.search();
            }else if(("3").equals(inputMenu.getMenuCode()))
            {
                BorrowCenter br=new BorrowCenter(bc);
                br.getBorrowList();
            }
        }
    }
}
