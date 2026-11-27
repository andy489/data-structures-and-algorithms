// https://leetcode.com/problems/kth-distinct-string-in-an-array/

// Solution: Frequency Count — O(n) time, O(n) space
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : arr) { freq.merge(s, 1, Integer::sum); }
        int count = 0;
        for (String s : arr) { if (freq.get(s) == 1 && ++count == k) { return s; } }
        return "";
    }
}
