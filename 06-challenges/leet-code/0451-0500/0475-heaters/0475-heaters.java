// https://leetcode.com/problems/heaters/

// Solution: Sort + Binary Search — O((H + N) log N) time, O(1) space
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            int distLeft = (pos > 0) ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int distRight = (pos < heaters.length) ? heaters[pos] - house : Integer.MAX_VALUE;
            minRadius = Math.max(minRadius, Math.min(distLeft, distRight));
        }
        return minRadius;
    }
}
