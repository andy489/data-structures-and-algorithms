// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

var findSpecialInteger = function(arr) {
    const q = arr.length >> 2;
    for (let i = 0; i + q < arr.length; i++) if (arr[i] === arr[i+q]) return arr[i];
    return -1;
};
