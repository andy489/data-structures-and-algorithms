// https://leetcode.com/problems/maximum-containers-on-a-ship/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
