import java.util.Map;
import java.util.TreeMap;

/**
 * Created by minkangyang on 09:56 Sat Jun, 2019
 * https://leetcode.com/problems/odd-even-jump/
 */
public class _43_OddEvenJump_975 {
    public static void main(String[] args) {

    }
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] Even = new boolean[n];
        boolean[] Odd = new boolean[n];
        // Even[i] represents if one can jump to end starting at ith index as a eventh jump
        // Odd[i] represents if one can jump to end starting at ith index as a oddth jump
        Even[n - 1] = true;
        Odd[n - 1] = true;
        int count = 1;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        // tm.put(A[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            // update Tree Map, time is log(n)
            tm.put(A[i + 1], i + 1);
            // for Even array
            // int k = -1;
            // boolean found = false;
            // int max = -1;
            // for (int j = i + 1; j < n; j++) {
            //     if (A[i] >= A[j]) {
            //         if (found == false || A[j] > max) {
            //             max = A[j];
            //             found = true;
            //             k = j;
            //         }
            //     }
            // }
            Map.Entry<Integer, Integer> entry = tm.floorEntry(A[i]);
            if (entry != null) {
                Even[i] = Odd[entry.getValue()];
            }
            //Even[i] = found == false ? false : Odd[k];

            // for Odd array
            // k = -1;
            // found = false;
            // int min = Integer.MAX_VALUE;
            // for (int j = i + 1; j < n; j++) {
            //     if (A[i] <= A[j]) {
            //         if (found == false || A[j] < min) {
            //             min = A[j];
            //             found = true;
            //             k = j;
            //         }
            //     }
            // }
            // Odd[i] = found == false ? false : Even[k];
            entry = tm.ceilingEntry(A[i]);
            if (entry != null) {
                Odd[i] = Even[entry.getValue()];
            }
            count += Odd[i] == false ? 0 : 1;
        }
        return count;
    }
}
