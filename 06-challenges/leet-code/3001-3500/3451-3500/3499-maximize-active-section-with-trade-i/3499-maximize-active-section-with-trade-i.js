// https://leetcode.com/problems/maximize-active-section-with-trade-i/

var maxActiveSectionsAfterTrade = function(s) {
    let totalOnes = 0;
    for (const c of s) {
        if (c === '1') totalOnes++;
    }

    // Augment with '1' at both ends
    const t = '1' + s + '1';
    const len = t.length;

    // Build run-length encoding
    const runs = [];
    let i = 0;
    while (i < len) {
        const c = t[i];
        let start = i;
        while (i < len && t[i] === c) i++;
        runs.push([c, i - start]);
    }

    let bestGain = 0;
    for (let idx = 1; idx < runs.length - 1; idx++) {
        if (runs[idx][0] === '1' && runs[idx - 1][0] === '0' && runs[idx + 1][0] === '0') {
            const gain = runs[idx - 1][1] + runs[idx + 1][1];
            bestGain = Math.max(bestGain, gain);
        }
    }

    return totalOnes + bestGain;
};
