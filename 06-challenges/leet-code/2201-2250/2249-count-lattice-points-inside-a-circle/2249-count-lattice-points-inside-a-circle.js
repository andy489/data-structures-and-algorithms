// https://leetcode.com/problems/count-lattice-points-inside-a-circle/

/**
 * @param {number[][]} circles
 * @return {number}
 */
var countLatticePoints = function (circles) {
    const seen = new Set();
    for (const [cx, cy, r] of circles) {
        for (let x = cx - r; x <= cx + r; x++) {
            for (let y = cy - r; y <= cy + r; y++) {
                const dx = x - cx, dy = y - cy;
                if (dx * dx + dy * dy <= r * r) {
                    seen.add(x * 201 + y);
                }
            }
        }
    }
    return seen.size;
};
