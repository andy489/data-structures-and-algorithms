// https://leetcode.com/problems/separate-the-digits-in-an-array/

// Solution: String Conversion — O(n * d) time, O(n * d) space
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            String s = Integer.toString(num);
            for (char c : s.toCharArray()) {
                result.add(c - '0');
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
