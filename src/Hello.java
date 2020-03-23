import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hello {
    public static void main(String[] args) throws ParseException {
        for(int i =0;i<40;i++){
            System.out.println("CREATE TABLE `erp_lock_"+i+"` ( `key` varchar(128) NOT NULL, `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, `total` int(8) DEFAULT '1', PRIMARY KEY (`key`) ) ENGINE = InnoDB CHARSET = utf8;");
        }


//        System.out.println("Hello World");
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//        System.out.println(minTimeFilter("2000-1-1 00:00:00",dateFormat));
//        System.out.println(minTimeFilter("2001-1-1 00:00:00",dateFormat));
//        System.out.println(minTimeFilter("1999-1-1 00:00:00",dateFormat));
    }



    public  static Date minTimeFilter(String payDate, SimpleDateFormat dateFormat) throws ParseException {

        Calendar minDate = Calendar.getInstance();
        minDate.setTime(dateFormat.parse("2000-1-1 00:00:00"));

        Calendar payTime = Calendar.getInstance();
        payTime.setTime(dateFormat.parse(payDate));

        payTime = payTime.before(minDate) ? minDate : payTime;


        return payTime.getTime();

    }


}

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

