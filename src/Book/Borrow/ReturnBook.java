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

    Inputclass inputclass=new Inputclass();

    public ReturnBook(BorrowCenter br,LoginCenter lc){
        this.br=br;
        this.lc=lc;

    }
    public void returnBook(){

        System.out.println("반납할 책 아이디를 입력하시오");

        InputMenu inputMenu=inputclass.getInputMenu();

        String bID = inputMenu.getMenuCode();

        returnWorkProcess (bID);
    }

    private void returnWorkProcess (String bID)
    {
        try
        {
            if(br.returnWork(bID))
            {
                System.out.println("정상 반납처리 되었습니다.");
            }
            else
                System.out.println("반납실패");

        }
        catch (ReturnBorrowException e)
        {
            //e.printStackTrace();
            System.out.println("연체되었습니다.");
            System.out.println(e.getBorrows().getOverDuePrice());
            System.out.println("연체료 계산 하시겠습니까?");
            System.out.println("1. 예    2. 아니요");
            InputMenu inputMenu1=inputclass.getInputMenu();

            if(inputMenu1.getMenuCode().equals("1"))
            {
                if (br.recvOverduePrice (e.getBorrows ()))
				{
					System.out.println("계산 됐습니다.");
					returnWorkProcess (bID);
				}
                else
                    System.err.println("연체료 계산에 실패했습니다..");

                return;
            }else if(inputMenu1.getMenuCode().equals("2")){
                System.out.println("나중되면 ㅈ됩니다.");
                return;
            }
        }
    }

}
