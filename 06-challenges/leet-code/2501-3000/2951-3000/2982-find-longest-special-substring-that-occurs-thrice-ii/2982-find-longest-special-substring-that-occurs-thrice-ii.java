// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/
class Solution {
    public int maximumLength(String s) {
        Map<Character, List<Integer>> runs = new HashMap<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            runs.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(j - i);
            i = j;
        }
        int result = -1;
        for (List<Integer> runLengths : runs.values()) {
            int maxRun = 0;
            for (int r : runLengths) {
                maxRun = Math.max(maxRun, r);
            }
            int lo = 1, hi = maxRun;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                long count = 0;
                for (int r : runLengths) {
                    count += Math.max(0, r - mid + 1);
                }
                if (count >= 3) {
                    result = Math.max(result, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return result;
    }
}
