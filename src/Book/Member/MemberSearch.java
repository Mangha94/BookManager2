package Book.Member;

import Book.InputMenu;
import Book.Inputclass;

import java.util.List;

/**
 * 회원 찾기 클래스
 */
public class MemberSearch {

    MemberCenter mc;

    public MemberSearch(MemberCenter mc){this.mc=mc;}

    public void Search()
    {
        while(true) {
            System.out.println("1. 아이디로 찾기");
            System.out.println("2. 이름으로 찾기");
            System.out.println("3. 연락처로 찾기");

            Inputclass in = new Inputclass();
            InputMenu inputMenu = in.getInputMenu();

            if(inputMenu.isBack())
                break;
            if (("1").equals(inputMenu.getMenuCode()))
            {
                System.out.println("아이디를 입력해주세요");
                Inputclass inputId = new Inputclass();
                InputMenu inputMenu1 = inputId.getInputMenu();
                System.out.println(mc.findByMemberID(inputMenu1.getMenuCode()));
            }
            else if (("2").equals(inputMenu.getMenuCode()))
            {
                System.out.println("이름을 입력해주세요");
                Inputclass inputName = new Inputclass();
                InputMenu inputMenu2 = inputName.getInputMenu();
                System.out.println(mc.findByName(inputMenu2.getMenuCode()));
            }
            else if (("3").equals(inputMenu.getMenuCode()))
            {
                System.out.println("연락처를 입력해주세요");
                Inputclass inputPhonNumber = new Inputclass();
                InputMenu inputMenu3 = inputPhonNumber.getInputMenu();
                System.out.println(mc.findByPhonNumber(inputMenu3.getMenuCode()));
            }
        }
    }

}
