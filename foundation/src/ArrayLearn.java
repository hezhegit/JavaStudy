import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ArrayLearn
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 12:47
 **/
public class ArrayLearn {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] arr2 = arr.clone();
        arr2[0] = 100;
        System.out.println(arr[0]); // 0

        // 浅拷贝只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存（分支）
        String[][] str = new String[2][2];
        str[0][0] = "Hello";
        str[0][1] = "World";
        String[][] str2 = str.clone();
        str2[0][0] = "Java";
        System.out.println(str[0][0]); // Java


        Integer[] arr5 = {2, 1, 9, 4, 6, 7, 3};
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5));
        Arrays.sort(arr5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        System.out.println(Arrays.toString(arr5));

        Entity[] entity = new Entity[5];
        entity[0] = new Entity(2, 5);
        entity[1] = new Entity(4, 3);
        entity[2] = new Entity(1, 9);
        entity[3] = new Entity(2, 7);
        entity[4] = new Entity(6, 10);
        Arrays.sort(entity);
        for (int i = 0; i < entity.length; i++) {
            System.out.println(entity[i].a+"==="+entity[i].b);
        }

    }
}
