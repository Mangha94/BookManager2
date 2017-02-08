package Book.BookAPL;

import Book.InputMenu;
import Book.Inputclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 입력받은 도서를 찾는 클래스
 */
public class BookSearch {

    Books book=new Books();
    BookCenter bc=new BookCenter();

    //제목으로 찾기
    public List<Books>findBytitle(String title)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:bc.books)
        {
            if(listBook.getTitle().equals(title))
                findList.add(listBook);
        }
        return findList;
    }

    //작가로 찾기
    public List<Books>findBywriter(String writer)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:bc.books)
        {
            if(listBook.getTitle().equals(writer))
                findList.add(listBook);
        }
        return findList;
    }

    //출판사로 찾기
    public List<Books>findBypublisher(String publisher)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:bc.books)
        {
            if(listBook.getTitle().equals(publisher))
                findList.add(listBook);
        }
        return findList;
    }

    public void search()
    {
        while(true) {
            System.out.println("1. 제목으로 찾기");
            System.out.println("2. 작가으로 찾기");
            System.out.println("3. 출판사으로 찾기");

            Inputclass in = new Inputclass();
            InputMenu inputMenu = in.getInputMenu();

            if(inputMenu.isBack())
                break;
            if (("1").equals(inputMenu.getMenuCode()))
            {
                System.out.println("책 제목을 입력해주세요");
                Inputclass inputTitle = new Inputclass();
                InputMenu inputMenu1 = inputTitle.getInputMenu();
                findBytitle(inputMenu1.getMenuCode());
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                System.out.println("작가을 입력해주세요");
                Inputclass inputwriter = new Inputclass();
                InputMenu inputMenu2 = inputwriter.getInputMenu();
                findBywriter(inputMenu2.getMenuCode());
            }
            else if (("3").equals(inputMenu.getMenuCode()))
            {
                System.out.println("출판사을 입력해주세요");
                Inputclass inputpublisher = new Inputclass();
                InputMenu inputMenu3 = inputpublisher.getInputMenu();
                findBypublisher(inputMenu3.getMenuCode());
            }
        }
    }

}
