package Book.BookAPL;

import Book.BookAPL.Books;

import java.util.ArrayList;
import java.util.List;

/**
 * 책 장부를 구성한다
 */
public class BookCenter
{

    private List<Books> books;

    public BookCenter()
    {
        books = new ArrayList<>();
    }

    public void addBook(Books book)
    {
        books.add(book);
    }

    public List<Books> getBooks()
    {
        List<Books> copyBooks=  new ArrayList<>(books);
        return copyBooks;
    }

    public boolean bookremove(String title)
    {
        Books remove = (Books) findBytitle(title);
        if(remove != null)
        {
            return books.remove(remove);
        }
        else
            return false;
    }

    private List<Books> search(String element,String keyWord)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:books)
        {
            String searchKey="";
            if(element.equals("title"))
                searchKey=listBook.getTitle();
            if(element.equals("writer"))
                searchKey=listBook.getWriter();
            if(element.equals("publisher"))
                searchKey=listBook.getPublisher();
            if(searchKey.contains(keyWord))
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
    //
}
