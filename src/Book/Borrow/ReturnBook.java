package Book.Borrow;

import Book.InputMenu;
import Book.Inputclass;
import Book.Login.LoginCenter;

/**
 * 반납관리 ui
 */
public class ReturnBook {
    BorrowCenter br;
    LoginCenter lc;
    public ReturnBook(BorrowCenter br,LoginCenter lc){
        this.br=br;
        this.lc=lc;
    }
    public void returnBook(){

        System.out.println("반납할 책 아이디를 입력하시오");
        Inputclass inputclass=new Inputclass();
        InputMenu inputMenu=inputclass.getInputMenu();

        try {
            if(br.returnWork(inputMenu.getMenuCode())){
                System.out.println("정상 반납처리 되었습니다.");
            }
            else
                System.out.println("반납실패");
        } catch (ReturnBorrowException e) {
            //e.printStackTrace();
            System.out.println("연체되었습니다.");
            System.out.println(e.getBorrows().getOverDuePrice());
            System.out.println("연체료 계산 하시겠습니까?");
            System.out.println("1. 예    2. 아니요");
            InputMenu inputMenu1=inputclass.getInputMenu();
            if(inputMenu1.getMenuCode().equals("1")){
                return;
            }else if(inputMenu1.getMenuCode().equals("2")){
                System.out.println("나중되면 ㅈ됩니다.");
                return;
            }
        }
    }

}
