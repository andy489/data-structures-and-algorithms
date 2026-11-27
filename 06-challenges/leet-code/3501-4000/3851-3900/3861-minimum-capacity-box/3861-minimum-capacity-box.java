// https://leetcode.com/problems/minimum-capacity-box/

class Solution {
    public int minimumCapacityBox(int[] capacity, int itemSize) {
        int bestIdx = -1;
        int bestCap = Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < bestCap) {
                bestCap = capacity[i];
                bestIdx = i;
            }
        }
        return bestIdx;
    }
}
