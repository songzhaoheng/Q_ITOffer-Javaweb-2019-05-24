package other;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@ToString
@Setter
@Getter
public class NowDate {

    private String date = null;
    private Timestamp timestamp = new Timestamp(new Date().getTime());

    public String getDate() {
        //设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // new Date()为获取当前系统时间
        date = simpleDateFormat.format(new Date());
        //System.out.println(simpleDateFormat.format(new Date()));
        return date;
    }

}
