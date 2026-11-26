// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

var smallestRange = function(nums) {
    const heap = [];
    let currentMax = -Infinity;
    for (let i = 0; i < nums.length; i++) {
        heap.push([nums[i][0], i, 0]);
        currentMax = Math.max(currentMax, nums[i][0]);
    }
    heap.sort((a, b) => a[0] - b[0]);

    let rangeStart = 0, rangeEnd = Infinity;

    while (heap.length === nums.length) {
        heap.sort((a, b) => a[0] - b[0]);
        const [val, listIdx, elemIdx] = heap.shift();
        if (currentMax - val < rangeEnd - rangeStart) {
            rangeStart = val;
            rangeEnd = currentMax;
        }
        if (elemIdx + 1 === nums[listIdx].length) break;
        const nextVal = nums[listIdx][elemIdx + 1];
        heap.push([nextVal, listIdx, elemIdx + 1]);
        currentMax = Math.max(currentMax, nextVal);
    }
    return [rangeStart, rangeEnd];
};
