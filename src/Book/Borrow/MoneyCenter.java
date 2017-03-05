package Book.Borrow;

import java.util.ArrayList;
import java.util.List;

/**
 * 연체료 납부 관련 메소드
 */
public class MoneyCenter{
    private List<Moneys> moneyList;

    public MoneyCenter(){
        moneyList=new ArrayList<>();
    }

    /**
     * 각종 정보들을 빼와 머니리스트에 저장
     * @param moneys
     */
    public void addMoney (Moneys moneys)
    {

        moneys.setTotalMoney(calcTotalMoney() + moneys.getLateMoney ());

        moneyList.add(moneys);
    }

    public long calcTotalMoney ()
    {
        long totalMoney = 0;

        for (Moneys m : moneyList)
            totalMoney += m.getLateMoney ();

        return totalMoney;
    }

    public List<Moneys> getMoneyList(){
        List<Moneys> getMoneyList=new ArrayList<>(moneyList);
        return getMoneyList;
    }
}
