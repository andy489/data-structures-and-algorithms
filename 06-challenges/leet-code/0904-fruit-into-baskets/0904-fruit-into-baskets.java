// https://leetcode.com/problems/fruit-into-baskets/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int totalFruit(int[] fruits) {
        int[] count = new int[fruits.length];
        int left = 0, distinct = 0, result = 0;
        for (int right = 0; right < fruits.length; right++) {
            if (count[fruits[right]]++ == 0) {
                distinct++;
            }
            while (distinct > 2) {
                if (--count[fruits[left++]] == 0) {
                    distinct--;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
