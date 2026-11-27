// https://leetcode.com/problems/count-complete-substrings/
class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int result = 0;
        int start = 0;
        while (start < n) {
            int end = start + 1;
            while (end < n && Math.abs(word.charAt(end) - word.charAt(end - 1)) <= 2) {
                end++;
            }
            result += countInSegment(word, start, end, k);
            start = end;
        }
        return result;
    }

    private int countInSegment(String word, int from, int to, int k) {
        int count = 0;
        int len = to - from;
        for (int m = 1; m <= 26; m++) {
            int windowSize = m * k;
            if (windowSize > len) {
                break;
            }
            int[] freq = new int[26];
            int satisfied = 0;
            for (int i = from; i < from + windowSize; i++) {
                int c = word.charAt(i) - 'a';
                freq[c]++;
                if (freq[c] == k) {
                    satisfied++;
                } else if (freq[c] == k + 1) {
                    satisfied--;
                }
            }
            if (satisfied == m) {
                count++;
            }
            for (int i = from + windowSize; i < to; i++) {
                int addC = word.charAt(i) - 'a';
                freq[addC]++;
                if (freq[addC] == k) {
                    satisfied++;
                } else if (freq[addC] == k + 1) {
                    satisfied--;
                }
                int removeC = word.charAt(i - windowSize) - 'a';
                freq[removeC]--;
                if (freq[removeC] == k - 1) {
                    satisfied--;
                } else if (freq[removeC] == k) {
                    satisfied++;
                }
                if (satisfied == m) {
                    count++;
                }
            }
        }
        return count;
    }
}
