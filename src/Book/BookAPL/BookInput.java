package Book.BookAPL;

import Book.BookAPL.BookCenter;
import Book.BookAPL.Books;
import Book.InputMenu;
import Book.Inputclass;

/**
 * 책을 등록하는 클래스
 */
public class BookInput {


    BookCenter bc = new BookCenter();

    public void input() {

        //todo 초기화 문제 발생
        while (true) {

            Books book = new Books();

            //제목을 입력받아 books 리스트에 넣는다
            System.out.println("제목을 입력해주세요");
            Inputclass inputTitle = new Inputclass();
            InputMenu inputMenu1 = inputTitle.getInputMenu();
            book.setTitle(inputMenu1.getMenuCode());

            //작가를 입력받아 books 리스트에 넣는다
            System.out.println("작가을 입력해주세요");
            Inputclass inputWriter = new Inputclass();
            InputMenu inputMenu2 = inputWriter.getInputMenu();
            book.setWriter(inputMenu2.getMenuCode());

            //출판사를 입력받아 books 리스트에 넣는다
            System.out.println("출판사을 입력해주세요");
            Inputclass inputPublisher = new Inputclass();
            InputMenu inputMenu3 = inputPublisher.getInputMenu();
            book.setPublisher(inputMenu3.getMenuCode());

            //가격을 입력받아 books 리스트에 넣는다
            System.out.println("가격을 입력해주세요");
            Inputclass inputPrice = new Inputclass();
            InputMenu inputMenu4 = inputPrice.getInputMenu();
            book.setPrice(inputMenu4.getMenuCode());

            //분류를 입력받아 books 리스트에 넣는다
            System.out.println("분류을 입력해주세요");
            Inputclass inputClassification = new Inputclass();
            InputMenu inputMenu5 = inputClassification.getInputMenu();
            book.setClassification(inputMenu5.getMenuCode());

            addBooks(book);
            return;
        }
    }
    public boolean addBooks(Books addbook)
    {
        bc.books.add(addbook);

        return true;
    }
}
