package Book.Member;

import Book.BookAPL.BookSearch;
import Book.InputMenu;
import Book.Inputclass;

import java.lang.reflect.Member;

/**
 * 회원 등록 클래스
 */
public class MemberInput {

    MemberCenter mc;

    public MemberInput(MemberCenter mc)
    {
        this.mc=mc;
    }

        public void input() {


            while (true) {

                Members members=new Members();

                //이름을 입력받는다
                System.out.println("이름을 입력해주세요");
                Inputclass inputName = new Inputclass();
                InputMenu inputMenu1 = inputName.getInputMenu();
                members.setName(inputMenu1.getMenuCode());

                //아이디을 입력받는다
                System.out.println("아이디을 입력해주세요");
                Inputclass inputId = new Inputclass();
                InputMenu inputMenu2 = inputId.getInputMenu();

                members.setId(inputMenu2.getMenuCode());

                //연락처을 입력받는다
                System.out.println("연락처를 입력해주세요");
                Inputclass inputPhonnumber = new Inputclass();
                InputMenu inputMenu3 = inputPhonnumber.getInputMenu();
                members.setPhonnumber(inputMenu3.getMenuCode());

                //생년월일을 입력받는다
                System.out.println("생년월일을 입력해주세요");
                Inputclass inputBirthday = new Inputclass();
                InputMenu inputMenu4 = inputBirthday.getInputMenu();
                members.setBirthday(inputMenu4.getMenuCode());

                addMembers(members);
                return;
            }
        }

        public boolean addMembers(Members addmember)
        {
            mc.addMembers(addmember);

            return true;
        }


}
