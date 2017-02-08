package Book.BookAPL;

import Book.BookAPL.Books;

import java.util.ArrayList;
import java.util.List;

/**
 * 책 장부를 구성한다
 */
public class BookCenter
{
    List<Books> bookcenter = new ArrayList<Books>();

    public List<Books> books;

    public BookCenter()
    {
        books = new ArrayList<>();
    }

}
