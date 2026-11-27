// https://leetcode.com/problems/count-largest-group/

// Solution: HashMap — O(n log n) time, O(n) space
class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int i = 1; i <= n; i++) groups.merge(digitSum(i), 1, Integer::sum);
        int maxSize = Collections.max(groups.values());
        int count = 0;
        for (int v : groups.values()) if (v == maxSize) count++;
        return count;
    }
    private int digitSum(int x) { int s = 0; while (x > 0) { s += x%10; x /= 10; } return s; }
}
