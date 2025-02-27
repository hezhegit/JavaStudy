import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        res.add(l1);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<Integer> refer = res.get(i - 2);

                if (j == 0) {
                    list.add(refer.getFirst());
                }else if (j == i -1){
                    list.add(refer.getLast());
                } else {
                    list.add(refer.get(j) + refer.get(j - 1));
                }
            }
            res.add(list);
        }
        return res;
    }
}
