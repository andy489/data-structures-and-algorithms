// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

var replaceElements = function(arr) {
    let maxRight = -1;
    for (let i = arr.length-1; i >= 0; i--) {
        const cur = arr[i]; arr[i] = maxRight; maxRight = Math.max(maxRight, cur);
    }
    return arr;
};
