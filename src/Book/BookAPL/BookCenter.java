package Book.BookAPL;

import Book.BookAPL.Books;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 책 장부를 구성한다
 */
public class BookCenter
{

    //todo 싱글턴(인스턴스
    private List<Books> booklist;
    BookIdAdd IdAdd=new BookIdAdd();

    public BookCenter()
    {
        booklist = new ArrayList<>();
    }

    public void addBook(Books book)
    {
            IdAdd.bookIdAdd(book);
            booklist.add(book);

    }

    public List<Books> getBooks()
    {
        List<Books> copyBooks=  new ArrayList<>(booklist);
        return copyBooks;
    }

    public boolean bookremove(String removetitle)
    {
        for(Books removeList:booklist) {
            if(removeList.getTitle().equals(findBytitle(removetitle)))
            booklist.remove(removetitle);
        }
        return true;
    }

    public boolean remove(String id){
        for(Books book:booklist){
            if(id.equals(book.getId())) {
                booklist.remove(book);
                return true;
            }
        }
        return false;
    }

    private List<Books> search(String element,String keyWord)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:booklist)
        {
            String searchKey="";
            if(element.equals("title"))
                searchKey=listBook.getTitle();
            if(element.equals("writer"))
                searchKey=listBook.getWriter();
            if(element.equals("publisher"))
                searchKey=listBook.getPublisher();
            if(element.equals("id"))
                searchKey=listBook.getId();
            if(searchKey!=null&&searchKey.contains(keyWord))
                findList.add(listBook);
        }
        return findList;
    }
    public List<Books> findBytitle(String title)
    {
        return search("title",title);
    }

    //작가로 찾기
    public List<Books>findBywriter(String writer)
    {
        return search("writer",writer);
    }

    //출판사로 찾기
    public List<Books>findBypublisher(String publisher)
    {
        return search("publisher",publisher);
    }
    //아이디로 찾기
    public List<Books>findById(String id){return search("id",id);}
}
