// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

function f(s) {
    let min = 'z';
    let count = 0;
    for (const c of s) {
        if (c < min) {
            min = c;
            count = 1;
        } else if (c === min) {
            count++;
        }
    }
    return count;
}

var numSmallerByFrequency = function(queries, words) {
    const wordFs = words.map(f).sort((a, b) => a - b);
    const m = wordFs.length;
    return queries.map(q => {
        const qf = f(q);
        // binary search: first index where wordFs[idx] > qf
        let lo = 0, hi = m;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (wordFs[mid] <= qf) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return m - lo;
    });
};
