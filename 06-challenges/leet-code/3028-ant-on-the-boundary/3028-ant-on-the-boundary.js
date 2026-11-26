// https://leetcode.com/problems/ant-on-the-boundary/

var returnToBoundaryCount = function(nums) {
    let pos = 0, count = 0;
    for (const x of nums) {
        pos += x;
        if (pos === 0) count++;
    }
    return count;
};
