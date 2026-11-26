// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

var checkPowersOfThree = function(n) {
    while (n > 0) {
        if (n % 3 === 2) {
            return false;
        }
        n = Math.floor(n / 3);
    }
    return true;
};
