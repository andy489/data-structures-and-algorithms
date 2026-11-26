// https://leetcode.com/problems/three-consecutive-odds/

var threeConsecutiveOdds = function(arr) {
    let count = 0;
    for (const x of arr) {
        if (x % 2 === 1) {
            count++;
            if (count === 3) {
                return true;
            }
        } else {
            count = 0;
        }
    }
    return false;
};
