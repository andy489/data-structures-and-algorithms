// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> dedup = new ArrayList<>();
        for (int num : nums) {
            if (dedup.isEmpty() || dedup.get(dedup.size() - 1) != num) {
                dedup.add(num);
            }
        }
        int count = 0;
        for (int i = 1; i < dedup.size() - 1; i++) {
            int prev = dedup.get(i - 1);
            int cur = dedup.get(i);
            int next = dedup.get(i + 1);
            if ((cur > prev && cur > next) || (cur < prev && cur < next)) {
                count++;
            }
        }
        return count;
    }
}
