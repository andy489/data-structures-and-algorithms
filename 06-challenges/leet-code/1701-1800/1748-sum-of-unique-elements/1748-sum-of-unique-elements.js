// https://leetcode.com/problems/sum-of-unique-elements/

var sumOfUnique = function(nums) {
    const freq = new Array(101).fill(0);
    for (const n of nums) {
        freq[n]++;
    }
    let sum = 0;
    for (let i = 1; i <= 100; i++) {
        if (freq[i] === 1) {
            sum += i;
        }
    }
    return sum;
};
