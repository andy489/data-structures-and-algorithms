// https://leetcode.com/problems/positions-of-large-groups/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(start)) {
                if (i - start >= 3) {
                    result.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        return result;
    }
}
