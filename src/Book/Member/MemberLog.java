package Book.Member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ttinfo on 2017-02-21.
 */
public class MemberLog {
        MemberCenter mc;
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        int cnt=0;
        Date date =new Date();

        public void MemberLog(MemberCenter mc){
            this.mc=mc;
        }

        public void memberLog(Members member){
            member.setRegDate(date);

            if(df.format (member.getRegDate()).equals(df.format(date))){
                ++cnt;
            }
            member.setLog(""+df.format(date)+ String.format(("0000%d"),cnt));
        }
    }

