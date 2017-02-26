package Book;

import Book.BookAPL.BookCenter;
import Book.Login.LoginCenter;
import Book.Member.MemberCenter;
import Book.Member.MemberInput;

/**
 * 로그인해서 관리자용 or 일반 유저용 연결 액세스는 패키지 전용이 될수있습니다. 액세스는 비공개가 될수 있습니다
 */
public class BookManagerLogin {

    MemberCenter mc;
    LoginCenter lc;
    BookCenter bc;
    BookManagerMenu bmm;

    public BookManagerLogin(LoginCenter lc, MemberCenter mc, BookCenter bc)
    {
        this.lc=lc;
        this.mc = mc;
        this.bc = bc;
    }

    public void bookMangerLogin() {

        System.out.println("도서관 프로그램 로그인 서비스");

            System.out.println("아이디를 입력해주세요.");
            Inputclass in = new Inputclass();
            InputMenu inputMenu2 = in.getInputMenu();
            if (inputMenu2.getMenuCode().equals("masterkey")) {
                System.out.println("관리자 등장!!");
                bmm.managerMenu();

            }
            else if (lc.login(inputMenu2.getMenuCode(),"")) {
                System.out.println(inputMenu2.getMenuCode() + "님 어서오세요");
                BookMenuForUser bmf=new BookMenuForUser(bc);
                bmf.bookMenuForUser();
            }
            else {
                System.out.println("존재하지 않는 아이디 입니다.");
                MemberInput mi=new MemberInput(mc);
                mi.input();
            }
        }
    }
