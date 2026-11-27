// https://leetcode.com/problems/watering-plants-ii/

// Solution: Two Pointers — O(n) time, O(1) space
var minimumRefill = function(plants, capacityA, capacityB) {
    let l = 0, r = plants.length - 1;
    let waterA = capacityA, waterB = capacityB;
    let refills = 0;

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

    if (l === r) {
        if (waterA >= waterB) {
            if (waterA < plants[l]) refills++;
        } else {
            if (waterB < plants[l]) refills++;
        }
    }

    return refills;
};
