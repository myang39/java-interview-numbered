import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 10:09 Sat Jun, 2019
 * https://leetcode.com/problems/brace-expansion/
 */
public class _54_BraceExpansion_1087 {
    public static void main(String[] args) {

    }
    public String[] expand(String S) {
        // parse the string
        List<List<String>> options = new LinkedList<>();
        int i = 0;
        while (i < S.length()) {
            List<String> option = new LinkedList<>();
            options.add(option);
            if (S.charAt(i) == '{') {
                i++;
                while (S.charAt(i) != '}') {
                    int j = i;
                    while (j < S.length() && isLetter(S.charAt(j))) {
                        j++;
                    }
                    option.add(S.substring(i, j));
                    if (S.charAt(j) == '}') {
                        i = j + 1;
                        break;
                    }
                    i = j + 1;
                }
            } else {
                int j = i;
                while ( j < S.length() && isLetter(S.charAt(j)) ) {
                    j++;
                }
                option.add(S.substring(i, j));
                i = j;
            }
        }
        // build the res
        List<String> res = options.get(0);
        for (int j = 1; j < options.size(); ++j) {
            List<String> next = options.get(j);
            List<String> temp = new LinkedList<String>();
            for (String old : res) {
                for (String option : next) {
                    temp.add(old + option);
                }
            }
            res = temp;
        }
        String[] resArr = new String[res.size()];
        resArr = res.toArray(resArr);
        Arrays.sort(resArr);
        return resArr;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
