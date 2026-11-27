// https://leetcode.com/problems/watering-plants-ii/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int waterA = capacityA, waterB = capacityB;
        int refills = 0;

        while (l < r) {
            if (waterA < plants[l]) {
                refills++;
                waterA = capacityA;
            }
            waterA -= plants[l];
            l++;

            if (waterB < plants[r]) {
                refills++;
                waterB = capacityB;
            }
            waterB -= plants[r];
            r--;
        }

        if (l == r) {
            int need = plants[l];
            if (waterA >= waterB) {
                if (waterA < need) {
                    refills++;
                }
            } else {
                if (waterB < need) {
                    refills++;
                }
            }
        }

        return refills;
    }
}
