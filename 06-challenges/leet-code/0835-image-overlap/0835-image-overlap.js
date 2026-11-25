// https://leetcode.com/problems/image-overlap/

var largestOverlap = function(img1, img2) {
    const n = img1.length;
    const ones1 = [], ones2 = [];
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (img1[r][c]) { ones1.push([r, c]); }
            if (img2[r][c]) { ones2.push([r, c]); }
        }
    }
    const offsets = new Map();
    let max = 0;
    for (const [r1, c1] of ones1) {
        for (const [r2, c2] of ones2) {
            const key = `${r1-r2},${c1-c2}`;
            const cnt = (offsets.get(key) || 0) + 1;
            offsets.set(key, cnt);
            max = Math.max(max, cnt);
        }
    }
    return max;
};
