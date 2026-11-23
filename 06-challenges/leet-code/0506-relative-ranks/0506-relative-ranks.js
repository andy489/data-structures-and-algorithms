// https://leetcode.com/problems/relative-ranks/

var findRelativeRanks = function(score) {
    const medals = ["Gold Medal", "Silver Medal", "Bronze Medal"];
    const result = new Array(score.length);
    const sorted = score.map((s, i) => [s, i]).sort((a, b) => b[0] - a[0]);
    sorted.forEach(([, origIdx], rank) => {
        result[origIdx] = rank < 3 ? medals[rank] : String(rank + 1);
    });
    return result;
};
