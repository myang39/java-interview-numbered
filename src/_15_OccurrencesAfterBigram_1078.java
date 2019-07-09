import java.util.ArrayList;
import java.util.List;

/**
 * Created by minkangyang on 20:27 Fri Jun, 2019
 * https://leetcode.com/problems/occurrences-after-bigram/
 */
public class _15_OccurrencesAfterBigram_1078 {
    public static void main(String[] args) {

    }

    public String[] findOcurrences(String text, String first, String second) {
        // first could be the same as second
        List<String> res = new ArrayList<>();
        String[] words = text.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (count == 2) {
                res.add(word);
                count = 0;
                // if (first == second) {
                //     count = 1;
                // }
            }
            if (count == 0) {
                if (word.equals(first)) {
                    count++;
                }
            } else if (count == 1) {
                if (word.equals(second)) {
                    count++;
                } else if (word.equals(first)) {
                    count = 1;
                } else {
                    count = 0;
                }
            }
        }
        String[] resArr = new String[res.size()];
        resArr = res.toArray(resArr);
        return resArr;
    }
}
