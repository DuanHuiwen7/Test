import java.lang.reflect.Field;
import java.util.Objects;

public class Test {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String oldname;

    private Integer age;

    public Test() {

    }

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        String s = "bb";
        t.setName(s);
        t.setOldname("aaaa");

        Test t1 = new Test();
        t1.setName(new String("bb"));
        t1.setOldname("aaa");
//        t1.setAge(9);
        t.bianLi(t, t1);
    }

    private void bianLi(Object oldMatch, Object newMatch) throws Exception {
        StringBuilder content = new StringBuilder();
        Field[] fields = newMatch.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            // 获取原来的访问控制权限
            boolean accessFlag = fields[i].isAccessible();
            // 修改访问控制权限
            fields[i].setAccessible(true);
            // 获取在对象f中属性fields[i]对应的对象中的变量
            Object oldValue = fields[i].get(oldMatch);
            Object newValue = fields[i].get(newMatch);
            System.out.println("value = " + oldValue + " " + newValue + "  " );
            System.out.println( oldValue != newValue && (oldValue == null || !oldValue.equals(newValue)));
            System.out.println( !Objects.equals(oldValue, newValue));

            // 恢复访问控制权限
            fields[i].setAccessible(accessFlag);
        }
    }
}
