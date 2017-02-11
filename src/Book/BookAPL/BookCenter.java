package Book.BookAPL;

import java.util.ArrayList;
import java.util.List;

/**
 * 책 장부를 구성한다
 */
public class BookCenter
{

    private List<Books> bookList;

    public BookCenter()
    {
        bookList = new ArrayList<>();
    }

    public void addBook(Books book)
    {
        // TODO 아이디를 부여한다.

        // TODO 아이디 부여 규칙은 년월일+인덱스

        bookList.add(book);
    }

    public List<Books> getBooks()
    {
        List<Books> copyBooks=  new ArrayList<>(bookList);
        return copyBooks;
    }

    public boolean bookremove(String title)
    {
        List<Books> bytitle = findBytitle (title);

        if (bytitle.size () > 0)
        {
            for (Books books : bytitle)
                bookList.remove (books);

            return true;
        }
        else
            return false;
    }

    private List<Books> search(String element,String keyWord)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook: bookList)
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
