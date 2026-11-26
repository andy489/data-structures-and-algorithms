// https://leetcode.com/problems/sequential-digits/

// Solution: Enumeration — O(1) time, O(1) space
// Solution: Enumeration — O(1) time, O(1) space
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        for (int len = 2; len <= 9; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int num = Integer.parseInt(digits.substring(start, start + len));
                if (num >= low && num <= high) res.add(num);
            }
        }
        Collections.sort(res);
        return res;
    }
}
