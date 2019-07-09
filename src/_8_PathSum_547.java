/**
 * Created by minkangyang on 20:08 Fri Jun, 2019
 * https://leetcode.com/problems/path-sum/
 */
public class _8_PathSum_547 {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) { // for every person
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
