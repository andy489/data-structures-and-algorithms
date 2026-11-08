// https://leetcode.com/problems/remove-element/

// Solution: Two Pointers — O(n) time, O(1) space
function removeElement(nums: number[], val: number): number {
    let k = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            nums[k++] = nums[i];
        }
    }
    return k;
}
