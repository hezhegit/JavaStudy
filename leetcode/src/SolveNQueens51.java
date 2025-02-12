import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens51 {
    // 列的全排列，去除 对角的（行号+列号）（行号减列号）
    List<List<String>> result = new ArrayList<>();
    boolean[] used;
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n];
        dfs(n, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(int n, List<Integer> col, int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    sb.append(j == col.get(i) ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for(int i=0; i<n; i++){
            if(!used[i] && !diagonals1.contains(row+i) && !diagonals2.contains(row-i)){
                used[i] = true;
                col.add(i);
                diagonals1.add(row+i);
                diagonals2.add(row-i);

                dfs(n, col, row+1);

                used[i] = false;
                col.remove(col.size()-1);
                diagonals1.remove(row+i);
                diagonals2.remove(row-i);
            }
        }

    }
}
