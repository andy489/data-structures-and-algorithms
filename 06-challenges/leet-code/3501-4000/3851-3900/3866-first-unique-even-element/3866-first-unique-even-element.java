// https://leetcode.com/problems/first-unique-even-element/

class Solution {
    public int firstUniqueEvenElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        for (int n : nums) {
            if (n % 2 == 0 && freq.get(n) == 1) {
                return n;
            }
        }
        return -1;
    }
}
