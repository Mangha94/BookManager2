package Book.Member;

import Book.InputMenu;
import Book.Inputclass;

import java.lang.reflect.Member;
import java.util.List;

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
                if(inputMenu.isBack ())
                    break;
                Members memberRemove=mc.findByID(inputMenu.getMenuCode());
                if(memberRemove.equals(null)){
                    System.out.println("그런 회원없습니다.");
                }
                else
                    mc.remove(memberRemove.getId());
                    System.out.println("삭제되었습니다.");
            }
        }

    }
