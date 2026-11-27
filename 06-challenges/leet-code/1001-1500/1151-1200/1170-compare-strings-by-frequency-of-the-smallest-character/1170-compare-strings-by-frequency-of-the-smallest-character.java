// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

// Solution: Sort + Binary Search — O((m + n) log m) time, O(m) space
class Solution {
    private int f(String s) {
        char min = 'z' + 1;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) {
                count++;
            }
        }
        return count;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length, m = words.length;
        int[] wordFs = new int[m];
        for (int i = 0; i < m; i++) {
            wordFs[i] = f(words[i]);
        }
        Arrays.sort(wordFs);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int qf = f(queries[i]);
            // find first index where wordFs[idx] > qf
            int lo = 0, hi = m;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (wordFs[mid] <= qf) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            answer[i] = m - lo;
        }
        return answer;
    }
}
