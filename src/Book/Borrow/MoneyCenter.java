package Book.Borrow;

import Book.Login.LoginCenter;
import Book.Login.LoginInfo;
import Book.Member.MemberCenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 연체료 납부 관련 메소드
 */
public class MoneyCenter{
    BorrowCenter br;
    LoginCenter lc;
    Borrows borrows;
    private List<Moneys> moneyList;

    public MoneyCenter(BorrowCenter br,LoginCenter lc){
        this.br=br;
        this.lc=lc;
        borrows=new Borrows();
        moneyList=new ArrayList<>();
    }

    /**
     * 각종 정보들을 빼와 머니리스트에 저장
     * @param moneys
     */
    public void addMeney(Moneys moneys){

        moneys.setDelinquent(borrows.getBorrwer());
        moneys.setPayDay(new Date());
        moneys.setLateMoney(borrows.getOverDuePrice());
        moneys.setTotalMoney(moneys.getTotalMoney()+borrows.getOverDuePrice());

        moneyList.add(moneys);
    }

    public List<Moneys> getMoneyList(){
        List<Moneys> getMoneyList=new ArrayList<>(moneyList);
        return getMoneyList;
    }
}
