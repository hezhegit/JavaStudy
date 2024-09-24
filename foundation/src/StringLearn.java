/**
 *@ClassName StringLearn
 *@Description TODO
 *@Author 小何
 *@Date 2024/9/21 19:14
**/
public class StringLearn {
    public static void main(String[] args) {
        String str = "Runoob"; // String => 常量池中
        String str2=new String("Runoob"); // new 的对象=》堆内存

        System.out.println(str == str2); // false => 地址不同
        System.out.println(str.equals(str2)); // true => 内容相同

        String str3 = "Runoob";
        System.out.println(str == str3); // true => 同一个地址：常量池

        String str4 = new String("Runoob");
        System.out.println(str2 == str4); // false => 每次new都是新的地址 堆

        String str5 = "Runoob hello";
        System.out.println(str == str5); //false
        System.out.println(str5.length());

        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.insert(8, "Java"); // Runoob..Java!
        System.out.println(sb);
        sb.delete(5,8);// RunooJava! =》删除[5,8)
        System.out.println(sb);
        System.out.println(sb.length()); //10


        StringBuilder st = new StringBuilder();
        st.append("Runoob");
        System.out.println(st.capacity());
        st.append("RunoobJavaJava");
        System.out.println(st.capacity());
        st.delete(3, 7);
        System.out.println(st.capacity());

    }
}

