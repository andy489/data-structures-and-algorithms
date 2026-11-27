// https://leetcode.com/problems/alphabet-board-path/

var alphabetBoardPath = function(target) {
    let res = '', cr = 0, cc = 0;
    for (const ch of target) {
        const idx = ch.charCodeAt(0) - 97;
        const tr = Math.floor(idx / 5), tc = idx % 5;
        const dr = tr - cr, dc = tc - cc;
        if (dr < 0) { res += 'U'.repeat(-dr); }
        if (dc < 0) { res += 'L'.repeat(-dc); }
        if (dr > 0) { res += 'D'.repeat(dr); }
        if (dc > 0) { res += 'R'.repeat(dc); }
        res += '!';
        cr = tr; cc = tc;
    }
    return res;
};
