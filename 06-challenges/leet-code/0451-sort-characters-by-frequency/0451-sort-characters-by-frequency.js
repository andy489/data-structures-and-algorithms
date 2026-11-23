// https://leetcode.com/problems/sort-characters-by-frequency/

var frequencySort = function(s) {
    const freq = new Map();
    for (const ch of s) {
        freq.set(ch, (freq.get(ch) || 0) + 1);
    }
    const buckets = Array.from({length: s.length + 1}, () => []);
    for (const [ch, cnt] of freq) {
        buckets[cnt].push(ch);
    }
    const result = [];
    for (let f = s.length; f >= 1; f--) {
        for (const ch of buckets[f]) {
            result.push(ch.repeat(f));
        }
    }
    return result.join('');
};
