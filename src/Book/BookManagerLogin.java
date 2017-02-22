package Book;

import Book.Member.MemberCenter;
import Book.Member.MemberInput;

/**
 * 로그인해서 관리자용 or 일반 유저용 연결
 */
public class BookManagerLogin {

    MemberCenter mc;
    Bookapp app=new Bookapp();

    public void BookManagerLogin(MemberCenter mc){
        this.mc=mc;
    }
    public void bookMangerLogin() {

        System.out.println("도서관 프로그램 로그인 서비스");
        System.out.println("1. 로그인      2.회원신규등록");

        Inputclass inputclass = new Inputclass();
        InputMenu inputMenu1 = inputclass.getInputMenu();

        if (inputMenu1.getMenuCode().equals("1"))
        {
            System.out.println("아이디를 입력해주세요.");
            Inputclass in = new Inputclass();
            InputMenu inputMenu2 = in.getInputMenu();
            if (inputMenu2.getMenuCode().equals("master of master")) {
                System.out.println("관리자 등장!!");
                app.start();
            }
            else if (mc.Login(inputMenu2.getMenuCode())) {
                System.out.println(inputMenu2.getMenuCode() + "님 어서오세요");
                app.startForUser();
            }
            else {
                System.out.println("존재하지 않는 아이디 입니다.");
            }
        }
        else if(inputMenu1.getMenuCode().equals("2")){
            MemberInput memberInput=new MemberInput(mc);
            memberInput.input();
        }
    }
}
