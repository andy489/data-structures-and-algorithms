// https://leetcode.com/problems/calculate-digit-sum-of-a-string/

// Solution: Simulation — O(n / k · n) time, O(n) space
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }
                next.append(sum);
            }
            s = next.toString();
        }
        return s;
    }
}
