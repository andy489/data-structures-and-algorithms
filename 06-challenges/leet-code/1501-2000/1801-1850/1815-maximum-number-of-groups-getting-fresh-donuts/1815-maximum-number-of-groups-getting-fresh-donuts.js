// https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/

var maxHappyGroups = function(batchSize, groups) {
    const freq = new Array(batchSize).fill(0);
    for (const g of groups) freq[g % batchSize]++;

    let happy = freq[0];
    freq[0] = 0;

    for (let i = 1; i <= Math.floor(batchSize / 2); i++) {
        const j = batchSize - i;
        if (i === j) {
            happy += Math.floor(freq[i] / 2);
            freq[i] %= 2;
        } else {
            const pairs = Math.min(freq[i], freq[j]);
            happy += pairs;
            freq[i] -= pairs;
            freq[j] -= pairs;
        }
    }

    const memo = new Map();

    function dp(state, cur) {
        const key = state.join(',') + '|' + cur;
        if (memo.has(key)) return memo.get(key);
        let best = 0;
        for (let i = 1; i < batchSize; i++) {
            if (state[i] > 0) {
                state[i]--;
                const nxt = (cur + i) % batchSize;
                const gain = nxt === 0 ? 1 : 0;
                best = Math.max(best, gain + dp(state, nxt));
                state[i]++;
            }
        }
        memo.set(key, best);
        return best;
    }

    return happy + dp(freq, 0);
};
