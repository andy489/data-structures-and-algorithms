// https://leetcode.com/problems/longest-happy-string/

var longestDiverseString = function(a, b, c) {
    const counts = [[a,'a'],[b,'b'],[c,'c']].filter(x => x[0] > 0);
    const res = [];
    while (true) {
        counts.sort((x,y) => y[0]-x[0]);
        const n = res.length;
        let idx = 0;
        if (n >= 2 && res[n-1] === counts[0][1] && res[n-2] === counts[0][1]) {
            if (counts.length < 2) break;
            idx = 1;
        }
        if (!counts[idx] || counts[idx][0] === 0) break;
        res.push(counts[idx][1]);
        counts[idx][0]--;
        if (counts[idx][0] === 0) counts.splice(idx, 1);
    }
    return res.join('');
};
