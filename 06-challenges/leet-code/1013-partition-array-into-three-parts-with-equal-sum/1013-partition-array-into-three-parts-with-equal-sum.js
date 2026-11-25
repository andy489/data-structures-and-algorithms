// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

var canThreePartsEqualSum = function(arr) {
    const total = arr.reduce((s, v) => s + v, 0);
    if (total % 3 !== 0) return false;
    const target = total / 3;
    let parts = 0, cur = 0;
    for (let i = 0; i < arr.length - 1; i++) {
        cur += arr[i];
        if (cur === target * (parts + 1)) {
            parts++;
            if (parts === 2) return true;
        }
    }
    return false;
};
