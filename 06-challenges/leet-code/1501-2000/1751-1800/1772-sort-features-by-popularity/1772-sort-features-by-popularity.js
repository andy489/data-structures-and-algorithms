// https://leetcode.com/problems/sort-features-by-popularity/

var sortFeatures = function(features, responses) {
    const count = new Map();
    for (const response of responses) {
        const seen = new Set(response.split(" "));
        for (const word of seen) {
            count.set(word, (count.get(word) || 0) + 1);
        }
    }
    return features
        .map((f, i) => [f, i])
        .sort(([fa, ia], [fb, ib]) => {
            const diff = (count.get(fb) || 0) - (count.get(fa) || 0);
            return diff !== 0 ? diff : ia - ib;
        })
        .map(([f]) => f);
};
