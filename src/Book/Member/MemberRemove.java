package Book.Member;

import Book.InputMenu;
import Book.Inputclass;

/**
 * 회원 삭제 클래스
 */
public class MemberRemove {

        MemberCenter mc;

        public MemberRemove(MemberCenter mc)
        {
            this.mc=mc;
        }



        public void Remove()
        {
            while(true)
            {
                System.out.println("삭제 할 아이디를 입력해주세요");
                Inputclass in = new Inputclass();
                InputMenu inputMenu = in.getInputMenu();
                if(mc.MemberRemove(inputMenu.getMenuCode()))
                    System.out.println(inputMenu.getMenuCode()+"가 삭제 되었습니다.");
                else
                    System.out.println("그런 책이 없습니다.");


            }
        }

    }
