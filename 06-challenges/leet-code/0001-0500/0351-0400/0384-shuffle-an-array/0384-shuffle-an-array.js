// https://leetcode.com/problems/shuffle-an-array/

// Solution: Fisher-Yates Shuffle — O(n) time, O(n) space
class Solution {
    constructor(nums) {
        this.original = [...nums];
        this.nums = nums;
    }

    reset() {
        this.nums.splice(0, this.nums.length, ...this.original);
        return this.nums;
    }

    shuffle() {
        for (let i = this.nums.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.nums[i], this.nums[j]] = [this.nums[j], this.nums[i]];
        }
        return this.nums;
    }
}
