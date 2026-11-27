// https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/

var isTransformable = function(s, t) {
    const pos = Array.from({length: 10}, () => []);
    for (let i = 0; i < s.length; i++) {
        pos[s[i] - '0'].push(i);
    }
    const ptr = new Array(10).fill(0);
    for (const c of t) {
        const d = c - '0';
        if (ptr[d] >= pos[d].length) return false;
        const idx = pos[d][ptr[d]];
        for (let smaller = 0; smaller < d; smaller++) {
            if (ptr[smaller] < pos[smaller].length && pos[smaller][ptr[smaller]] < idx) {
                return false;
            }
        }
        ptr[d]++;
    }
    return true;
};
