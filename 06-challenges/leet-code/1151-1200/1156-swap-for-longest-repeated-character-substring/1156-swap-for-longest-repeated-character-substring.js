// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

var maxRepOpt1 = function(text) {
    const count = new Array(26).fill(0);
    for (const c of text) {
        count[c.charCodeAt(0) - 97]++;
    }
    // Build run-length encoding
    const runs = [];
    let i = 0, n = text.length;
    while (i < n) {
        let j = i;
        while (j < n && text[j] === text[i]) {
            j++;
        }
        runs.push([text.charCodeAt(i) - 97, j - i]);
        i = j;
    }
    let ans = 0;
    for (let r = 0; r < runs.length; r++) {
        const [ch, len] = runs[r];
        let best = Math.min(len + 1, count[ch]);
        if (r + 2 < runs.length && runs[r + 1][1] === 1 && runs[r + 2][0] === ch) {
            const merged = len + runs[r + 2][1] + 1;
            best = Math.max(best, Math.min(merged, count[ch]));
        }
        ans = Math.max(ans, best);
    }
    return ans;
};
