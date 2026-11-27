// https://leetcode.com/problems/rings-and-rods/

// Solution: Bitmask per Rod — O(n) time, O(1) space
var countPoints = function(rings) {
    const mask = new Array(10).fill(0);
    const colorBit = { 'R': 1, 'G': 2, 'B': 4 };

    for (let i = 0; i < rings.length; i += 2) {
        const color = rings[i];
        const rod = parseInt(rings[i + 1]);
        mask[rod] |= colorBit[color];
    }

    return mask.filter(m => m === 7).length;
};
