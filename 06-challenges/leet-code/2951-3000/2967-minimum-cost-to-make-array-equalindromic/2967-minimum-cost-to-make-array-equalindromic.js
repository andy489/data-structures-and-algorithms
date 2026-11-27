// https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/
var minimumCost = function(nums) {
    const isPalindrome = (n) => {
        const s = String(n);
        return s === s.split('').reverse().join('');
    };
    const cost = (target) => nums.reduce((acc, x) => acc + Math.abs(x - target), 0);

    nums.sort((a, b) => a - b);
    let left = nums[Math.floor(nums.length / 2)];
    let right = left;
    while (!isPalindrome(left)) left--;
    while (!isPalindrome(right)) right++;
    return Math.min(cost(left), cost(right));
};
