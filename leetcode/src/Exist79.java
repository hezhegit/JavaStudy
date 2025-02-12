public class Exist79 {
    boolean found = false;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 枚举 所有开始的节点
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, 0, i, j);
                    if (found) return true;
                }
            }
        }

        return found;
    }

    public void dfs(char[][] board, String word, int k, int i, int j) {
        // 临界条件
        if (found) return;

        if (k == word.length()) {
            found = true;
            return;
        }

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return;
        }
        if (board[i][j] != word.charAt(k)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        // 递归（上下左右）+ 回朔
        visited[i][j] = true;
        dfs(board, word, k + 1, i-1, j);
        dfs(board, word, k + 1, i, j-1);
        dfs(board, word, k + 1, i+1, j);
        dfs(board, word, k + 1, i, j+1);
        visited[i][j] = false;

    }
}
