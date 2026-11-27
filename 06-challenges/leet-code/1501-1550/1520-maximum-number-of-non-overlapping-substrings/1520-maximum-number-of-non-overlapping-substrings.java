// https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

// Solution: Greedy Interval Expansion — O(n * 26) time, O(n) space
class Solution {
    private int[] first = new int[26];
    private int[] last = new int[26];
    private String s;

    public List<String> maxNumOfSubstrings(String s) {
        this.s = s;
        int n = s.length();
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != i) {
                continue; // not the first occurrence of this char
            }
            int r = getRight(i);
            if (r == -1) {
                continue;
            }
            if (i > prevEnd) {
                result.add(s.substring(i, r + 1));
                prevEnd = r;
            } else {
                // try to replace last with smaller ending interval
                String prev = result.get(result.size() - 1);
                if (r + 1 - i < prev.length()) {
                    result.set(result.size() - 1, s.substring(i, r + 1));
                    prevEnd = r;
                }
            }
        }
        return result;
    }

    private int getRight(int i) {
        int r = last[s.charAt(i) - 'a'];
        for (int j = i; j <= r; j++) {
            int c = s.charAt(j) - 'a';
            if (first[c] < i) {
                return -1;
            }
            r = Math.max(r, last[c]);
        }
        return r;
    }
}
