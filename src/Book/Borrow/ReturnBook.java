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

        for(Borrows borrows:br.getUserBorrowList()) {
            if (inputMenu.getMenuCode().equals(borrows.getId()) && borrows.getBorrwer().equals(lc.getLoginInfo())) {
                br.Return(inputMenu.getMenuCode());
            }
            return;
        }
        System.out.println("정상 반납처리 되었습니다.");
    }

}
