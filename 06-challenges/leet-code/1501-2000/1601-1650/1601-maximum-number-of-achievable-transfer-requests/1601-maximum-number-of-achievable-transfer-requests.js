// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

var maximumRequests = function(n, requests) {
    const r = requests.length;
    let best = 0;
    for (let mask = 0; mask < (1 << r); mask++) {
        const delta = new Array(n).fill(0);
        let cnt = 0;
        for (let i = 0; i < r; i++) {
            if ((mask >> i) & 1) {
                delta[requests[i][0]]--;
                delta[requests[i][1]]++;
                cnt++;
            }
        }
        if (delta.every(d => d === 0)) {
            best = Math.max(best, cnt);
        }
    }
    return best;
};
