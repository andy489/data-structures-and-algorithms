// https://leetcode.com/problems/largest-values-from-labels/

var largestValsFromLabels = function(values, labels, numWanted, useLimit) {
    const pairs = values.map((v, i) => [v, labels[i]]).sort((a, b) => b[0] - a[0]);
    const labelCount = new Map();
    let total = 0, chosen = 0;
    for (const [v, l] of pairs) {
        if (chosen >= numWanted) break;
        if ((labelCount.get(l)||0) < useLimit) {
            total += v;
            labelCount.set(l, (labelCount.get(l)||0)+1);
            chosen++;
        }
    }
    return total;
};
