package Book.Borrow;

import java.util.Date;

/**
 * 연체료 장부
 * 연체료 낸 사람과 낸금액, 총금액,낸 날짜
 */
public class Moneys {
    private String delinquent;
    private int lateMoney;
    private int totalMoney;

    public String getDelinquent() {
        return delinquent;
    }

    public void setDelinquent(String delinquent) {
        this.delinquent = delinquent;
    }

    public int getLateMoney() {
        return lateMoney;
    }

    public void setLateMoney(int lateMoney) {
        this.lateMoney = lateMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    private Date payDay;

    public Moneys(){
        delinquent="";
        lateMoney=0;
        totalMoney=0;
    }
    public String toString()
    {
        return "[납부자='"+delinquent+'\''+
                "납부일자='"+payDay+'\''+
                "납부액='"+lateMoney+'\''+
                "총금액='"+totalMoney+'\''+
                ']'+"\n";
    }
}
