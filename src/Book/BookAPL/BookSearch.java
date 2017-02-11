package Book.BookAPL;

import Book.InputMenu;
import Book.Inputclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 입력받은 도서를 찾는 클래스
 */
public class BookSearch {

    BookCenter bc;

    public BookSearch(BookCenter bc) {
        this.bc = bc;
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
                System.out.println(bc.findBytitle(inputMenu1.getMenuCode()));
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                System.out.println("작가을 입력해주세요");
                Inputclass inputwriter = new Inputclass();
                InputMenu inputMenu2 = inputwriter.getInputMenu();
                System.out.println(bc.findBywriter(inputMenu2.getMenuCode()));
            }
            else if (("3").equals(inputMenu.getMenuCode()))
            {
                System.out.println("출판사을 입력해주세요");
                Inputclass inputpublisher = new Inputclass();
                InputMenu inputMenu3 = inputpublisher.getInputMenu();
                System.out.println(bc.findBypublisher(inputMenu3.getMenuCode()));
            }
        }
    }

}
