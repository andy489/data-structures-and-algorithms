// https://leetcode.com/problems/three-equal-parts/

var threeEqualParts = function(arr) {
    const ones = arr.reduce((acc, x, i) => { if (x) acc.push(i); return acc; }, []);
    if (!ones.length) return [0, 2];
    if (ones.length % 3 !== 0) return [-1, -1];
    const each = ones.length / 3;
    let i1 = ones[0], i2 = ones[each], i3 = ones[2*each];
    const n = arr.length;
    while (i3 < n && arr[i1] === arr[i2] && arr[i2] === arr[i3]) { i1++; i2++; i3++; }
    return i3 === n ? [i1-1, i2] : [-1, -1];
};
