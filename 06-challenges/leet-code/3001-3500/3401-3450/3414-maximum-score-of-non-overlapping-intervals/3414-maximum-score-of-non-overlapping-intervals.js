// https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
var maximumWeight = function(intervals) {
    const n = intervals.length;
    const arr = intervals.map((iv, i) => [iv[0], iv[1], iv[2], i]);
    arr.sort((a, b) => a[1] !== b[1] ? a[1] - b[1] : a[0] !== b[0] ? a[0] - b[0] : a[3] - b[3]);

    const rights = arr.map(x => x[1]);
    const K = 4;
    const NEG_INF = -Infinity;

    const dp = Array.from({length: K + 1}, () => new Array(n).fill(NEG_INF));
    const prevIdx = Array.from({length: K + 1}, () => new Array(n).fill(-1));

    function bisectLeft(arr, val) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    for (let k = 1; k <= K; k++) {
        for (let i = 0; i < n; i++) {
            const left = arr[i][0];
            const j = bisectLeft(rights, left) - 1;
            if (k === 1) {
                dp[k][i] = arr[i][2];
                prevIdx[k][i] = -1;
            } else if (j >= 0 && dp[k - 1][j] !== NEG_INF) {
                dp[k][i] = dp[k - 1][j] + arr[i][2];
                prevIdx[k][i] = j;
            }
        }
    }

    let bestVal = NEG_INF, bestK = -1, bestI = -1;
    for (let k = 1; k <= K; k++) {
        for (let i = 0; i < n; i++) {
            if (dp[k][i] !== NEG_INF && dp[k][i] > bestVal) {
                bestVal = dp[k][i];
                bestK = k;
                bestI = i;
            }
        }
    }

    const result = [];
    let curK = bestK, curI = bestI;
    while (curI >= 0 && curK >= 1) {
        result.push(arr[curI][3]);
        const nextI = prevIdx[curK][curI];
        curK--;
        curI = nextI;
    }
    result.sort((a, b) => a - b);
    return result;
};
