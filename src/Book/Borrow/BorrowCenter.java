package Book.Borrow;

import Book.BookAPL.BookCenter;
import Book.BookAPL.Books;
import Book.Member.MemberCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttinfo on 2017-02-26.
 */
public class BorrowCenter {
    BookCenter bc;
    MemberCenter mc;
    public BorrowCenter(BookCenter bc){
        this.bc=bc;
    }
    List<Books> borrowList=new ArrayList<>();
    /**
     * id로 찾아서 대여장부에 추가
     * @param id
     * @return
     */
    public List<Books> borrow(String id)
    {
        for(Books borrowBook:bc.getBooks())
        {
            if(id.equals(bc.findById(id))) {
                borrowList.add(borrowBook);
                bc.borrowBook(id);
            }
        }
        return borrowList;
    }

    /**
     * 빌린리스트를 표출
     * @return
     */
    public List<Books>getBorrowList(){
        List<Books> borrowBookList=new ArrayList<>(borrowList);
        return borrowBookList;
    }

    /*public List<Books>Return(String id){
        for(Books returnBook:borrowList){

        }

    }
    */
}