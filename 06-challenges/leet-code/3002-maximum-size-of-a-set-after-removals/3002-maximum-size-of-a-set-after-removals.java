// https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

// Solution: Greedy Set Intersection — O(n) time, O(n) space
class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int x : nums1) { set1.add(x); }
        for (int x : nums2) { set2.add(x); }
        int n = nums1.length, half = n / 2;
        int only1 = 0, only2 = 0, shared = 0;
        for (int x : set1) { if (set2.contains(x)) { shared++; } else { only1++; } }
        for (int x : set2) { if (!set1.contains(x)) { only2++; } }
        int take1 = Math.min(only1, half), take2 = Math.min(only2, half);
        int rem = n - take1 - take2;
        return take1 + take2 + Math.min(shared, rem);
    }
}
