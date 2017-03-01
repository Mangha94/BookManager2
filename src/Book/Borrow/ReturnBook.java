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
            if(!br.overdue()){
                System.out.println("연체되었습니다.");
                //todo 연체료 계산 메소드
                System.out.println("연체료 계산 하시겠습니까?");
                System.out.println("1. 예    2. 아니요");
                InputMenu inputMenu1=inputclass.getInputMenu();
                if(inputMenu1.getMenuCode().equals("1")){
                    //todo 얼마입니다
                    return;
                }else if(inputMenu1.getMenuCode().equals("2")){
                    System.out.println("나중되면 ㅈ됩니다.");
                    return;
                }

            }
            if (inputMenu.getMenuCode().equals(borrows.getId()) && borrows.getBorrwer().equals(lc.getLoginInfo())) {
                br.Return(inputMenu.getMenuCode());
            }
            return;
        }
        System.out.println("정상 반납처리 되었습니다.");
    }

}
