package Book.Member;

import Book.InputMenu;
import Book.Inputclass;

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

            Members members = new Members();

            System.out.println ("회원을 신규 등록합니다");

			Inputclass input = new Inputclass();

            //이름을 입력받는다
            System.out.println("이름을 입력해주세요");
            InputMenu inputMenu1 = input.getInputMenu();
            members.setName(inputMenu1.getMenuCode());

            //아이디을 입력받는다
            while (true) {
                System.out.println("아이디을 입력해주세요");

                InputMenu inputMenu2 = input.getInputMenu();
                System.out.println(inputMenu2.getMenuCode());

                Members memberId = mc.findByID(inputMenu2.getMenuCode());

                if (memberId == null) {
                    members.setId(inputMenu2.getMenuCode());
                    System.out.println("사용가능한 아이디 입니다.");
                    break;
                } else
                    System.out.println("중복된 아이디 입니다.");
            }

			System.out.println("비밀번호를 입력해주세요");

			InputMenu inputMenu5 = input.getInputMenu();
			members.setPw(inputMenu5.getMenuCode());

			//연락처을 입력받는다
			System.out.println("연락처를 입력해주세요");
			InputMenu inputMenu3 = input.getInputMenu();
			members.setPhonnumber(inputMenu3.getMenuCode());

			//생년월일을 입력받는다
			System.out.println("생년월일을 입력해주세요");

			InputMenu inputMenu4 = input.getInputMenu();
			members.setBirthday(inputMenu4.getMenuCode());

			addMembers(members);
			System.out.println("등록되었습니다.");
        }

        public boolean addMembers(Members addmember)
        {
            mc.addMembers(addmember);

            return true;
        }


}
