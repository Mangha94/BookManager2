package Book.BookAPL;

import Book.InputMenu;
import Book.Inputclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서 삭제 클래스
 */
public class BookRemove {
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
            if(inputMenu.isBack ())
                break;

            List<Books> removeBooks =bc.findBytitle(inputMenu.getMenuCode());
            if(removeBooks.size()==0){
                System.out.println("책이 없습니다.");
            }else if(removeBooks.size()==1){
                if(bc.remove(removeBooks.get(0).getId())){
                    System.out.println("삭제되었습니다.");
                }
                else
                    System.out.println("책이 없습니다.");
            }
            else
            {
                System.out.println("전부 삭제 하시겠습니까?");
                System.out.println("1.예     2.아니요");
                Inputclass inputclass1=new Inputclass();
                InputMenu inputMenu1=inputclass1.getInputMenu();
                if(inputMenu1.getMenuCode().equals("1")) {
                    for (Books booksRemove : removeBooks) {
                        bc.remove(booksRemove.getId());
                    }
                }
                else
                    System.out.println(removeBooks);
                    System.out.println("삭제 할 책 아이디를 입력해주세요");
                Inputclass inputclass2=new Inputclass();
                InputMenu inputMenu2=inputclass2.getInputMenu();
                List<Books>removeBookById=bc.findById(inputMenu2.getMenuCode());
                    if(removeBookById.size()==1){
                        if(bc.remove(removeBookById.get(0).getId())){
                            System.out.println("삭제되었습니다.");
                        }
                        else
                            System.out.println("아이디를 잘못입력하셨습니다.");

                }
            }
          }

    }

}
