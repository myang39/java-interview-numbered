import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 20:28 Fri Jun, 2019
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class _16_SmallestSubsequenceOfDistinctCharacters_1081 {
    public static void main(String[] args) {

    }
    public String smallestSubsequence(String text) {
        List<Character> res = new LinkedList<>(); // add and remove -> using LinkedList. Just add -> using ArrayList
        int[] used = new int[26];
        int[] cnt = new int[26];
        for (Character c : text.toCharArray()) {cnt[c - 'a']++;}
        for (Character c : text.toCharArray()) {
            cnt[c - 'a']--;
            if (used[c - 'a']++ > 0) {continue;} // first check if > 0, and also ++
            while (res.size() > 0 && res.get(res.size() - 1) > c && cnt[res.get(res.size() - 1) - 'a'] > 0) {
                used[res.get(res.size() - 1) - 'a'] = 0;
                res.remove(res.size() - 1);

            }
            res.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : res) {sb.append(c);}
        return sb.toString();
    }
}
