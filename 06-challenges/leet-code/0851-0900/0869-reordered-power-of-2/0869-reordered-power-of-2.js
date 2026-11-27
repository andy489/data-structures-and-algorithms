// https://leetcode.com/problems/reordered-power-of-2/

var reorderedPowerOf2 = function(n) {
    const target = String(n).split('').sort().join('');
    for (let i = 0; i < 30; i++) {
        if (String(1 << i).split('').sort().join('') === target) return true;
    }
    return false;
};
