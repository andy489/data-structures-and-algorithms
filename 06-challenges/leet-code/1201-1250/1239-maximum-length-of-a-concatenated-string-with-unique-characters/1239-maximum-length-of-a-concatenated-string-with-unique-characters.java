// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

// Solution: Bitmask DP — O(2^n) time, O(2^n) space
// Solution: Bitmask DP — O(2^n) time, O(2^n) space
class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            boolean dup = false;
            for (char c : s.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((mask & bit) != 0) { dup = true; break; }
                mask |= bit;
            }
            if (!dup) masks.add(mask);
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (int m : masks) {
            List<Integer> newDp = new ArrayList<>();
            for (int d : dp) {
                if ((d & m) == 0) {
                    newDp.add(d | m);
                    res = Math.max(res, Integer.bitCount(d | m));
                }
            }
            dp.addAll(newDp);
        }
        return res;
    }
}
