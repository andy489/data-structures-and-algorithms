// https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

var sumOfEncryptedInt = function(nums) {
    return nums.reduce((acc, x) => {
        const s = String(x);
        const maxD = Math.max(...s.split('').map(Number));
        return acc + parseInt(String(maxD).repeat(s.length));
    }, 0);
};
