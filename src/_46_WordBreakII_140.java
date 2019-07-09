import java.util.*;

/**
 * Created by minkangyang on 09:58 Sat Jun, 2019
 * https://leetcode.com/problems/word-break-ii/
 */
public class _46_WordBreakII_140 {
    public static void main(String[] args) {

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        // corner case
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        else if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        HashSet<String> wd = new HashSet<>();
        for (String ss : wordDict) {
            wd.add(ss);
        }

        boolean[] Look = new boolean[s.length()];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        // Look[i] represents whether S[0..i] can be Dicted.

        for (int i = 0; i < s.length(); ++i) {
            if (wd.contains(s.substring(0, i+1))) {
                Look[i] = true;
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                hm.put(i, list);
            }
            for (int j = 0; j < i; ++j) {
                if (Look[j] && wd.contains(s.substring(j+1, i+1))) {
                    Look[i] = true;
                    List<Integer> list = hm.get(i);
                    if (list == null) {
                        list = new LinkedList<>();
                    }
                    list.add(j);
                    hm.put(i, list);
                }
            }
        }

        // DFS

        if (Look[s.length() - 1] == true) {
            get_path(s, s.length() - 1, hm, res, new LinkedList<Integer>());
        } else {
            return res;
        }

        return res;
    }

    private void get_path(String s, int pos, HashMap<Integer, List<Integer>> hm, List<String> res, List<Integer> path) {
        if (pos == -1) {
            path.add(-1);
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i > 0; i--) {
                sb.append( s.substring( path.get(i) + 1, path.get(i - 1) + 1) );
                if (i != 1) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }
        path.add(pos);
        List<Integer> list = hm.get(pos);
        for (int i = 0; i < list.size(); i++) {
            get_path(s, list.get(i), hm, res, path);
        }
        path.remove(path.size() - 1);
    }
}
