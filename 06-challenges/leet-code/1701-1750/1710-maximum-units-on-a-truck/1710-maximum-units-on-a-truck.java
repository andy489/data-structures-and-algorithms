// https://leetcode.com/problems/maximum-units-on-a-truck/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        int remaining = truckSize;
        for (int[] box : boxTypes) {
            int take = Math.min(box[0], remaining);
            units += take * box[1];
            remaining -= take;
            if (remaining == 0) {
                break;
            }
        }
        return units;
    }
}
