// https://leetcode.com/problems/unique-number-of-occurrences/

// Solution: HashMap + HashSet — O(n) time, O(n) space
// Solution: HashMap + HashSet — O(n) time, O(n) space
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        return new HashSet<>(freq.values()).size() == freq.size();
    }
}
