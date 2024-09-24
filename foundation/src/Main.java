/**
 * @ClassName Main
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/23 22:46
 **/
public class Main {
    public static void main(String[] args) {
       int i = 0;
       try {
           System.out.println(i);
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }finally {
           System.out.println(i+1);
       }

       try {
           System.out.println(9/i);
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }finally {
           System.out.println(i+6);
       }

    }
}
