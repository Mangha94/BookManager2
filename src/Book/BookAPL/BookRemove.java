package Book.BookAPL;

import Book.InputMenu;
import Book.Inputclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서 삭제 클래스
 */
public class BookRemove {

    Books b=new Books();
    BookCenter bc;

    public BookRemove(BookCenter bc)
    {
        this.bc=bc;
    }



    public void Remove()
    {
        while(true)
        {
            System.out.println("삭제 할 책 제목을 입력해주세요");
            Inputclass in = new Inputclass();
            InputMenu inputMenu = in.getInputMenu();
            if(bc.bookremove(inputMenu.getMenuCode()))
                System.out.println(inputMenu.getMenuCode()+"가 삭제 되었습니다.");
            else
                System.out.println("그런 책이 없습니다.");


        }
    }

}
