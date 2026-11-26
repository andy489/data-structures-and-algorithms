// https://leetcode.com/problems/fair-candy-swap/

// Solution: HashSet — O(m+n) time, O(n) space
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        Set<Integer> bobSet = new HashSet<>();
        for (int a : aliceSizes) { sumA += a; }
        for (int b : bobSizes) { sumB += b; bobSet.add(b); }
        int delta = (sumB - sumA) / 2;
        for (int a : aliceSizes) {
            if (bobSet.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }
        return new int[0];
    }
}
