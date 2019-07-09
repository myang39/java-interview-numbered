import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by minkangyang on 09:34 Sat Jun, 2019
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class _35_ShortestDistancefromAllBuildings_317 {
    public static void main(String[] args) {

    }
    public int shortestDistance(int[][] grid) {
        int buildings = count_buildings(grid);
        int m = grid.length;
        int n = grid[0].length;

        Integer min_total = null;
        // BFS for shortest distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int total = 0;
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int distance = 0;
                    int buildings_found = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] cur = queue.poll();
                            int x = cur[0];
                            int y = cur[1];
                            if (grid[x][y] == 1) {
                                total += distance;
                                buildings_found ++;
                                continue;
                            }
                            // add the new level
                            if (x - 1 >= 0 && grid[x - 1][y] < 2 && visited[x - 1][y] == false) {
                                queue.offer(new int[]{x - 1, y});
                                visited[x - 1][y] = true;
                            }
                            if (x + 1 < m && grid[x + 1][y] < 2 && visited[x + 1][y] == false) {
                                queue.offer(new int[]{x + 1, y});
                                visited[x + 1][y] = true;
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] < 2 && visited[x][y - 1] == false) {
                                queue.offer(new int[]{x, y - 1});
                                visited[x][y - 1] = true;
                            }
                            if (y + 1 < n && grid[x][y + 1] < 2 && visited[x][y + 1] == false) {
                                queue.offer(new int[]{x, y + 1});
                                visited[x][y + 1] = true;
                            }
                        }
                        distance++;
                    }
//                    System.out.println("buildings_found:" + buildings_found);
                    if (buildings_found == buildings) {
                        min_total = min_total == null ? total : Math.min(min_total, total);
                    }
                }
            }
        }
        return min_total == null ? -1 : min_total;
    }

    private int count_buildings (int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j] == 1 ? 1 : 0;
            }
        }
        return count;
    }
}
