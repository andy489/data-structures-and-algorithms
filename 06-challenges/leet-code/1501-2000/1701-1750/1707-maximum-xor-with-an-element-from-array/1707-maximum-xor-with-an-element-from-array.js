// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/

var maximizeXor = function(nums, queries) {
    nums.sort((a, b) => a - b);
    const q = queries.length;
    const qIdx = Array.from({length: q}, (_, i) => i);
    qIdx.sort((a, b) => queries[a][1] - queries[b][1]);

    const trie = new Int32Array(6400000 * 2).fill(0);
    let trieSize = 1;

    const insert = (num) => {
        let node = 0;
        for (let i = 29; i >= 0; i--) {
            const bit = (num >> i) & 1;
            if (trie[node * 2 + bit] === 0) {
                trie[node * 2 + bit] = trieSize++;
            }
            node = trie[node * 2 + bit];
        }
    };

    const queryMax = (x) => {
        let node = 0;
        let result = 0;
        for (let i = 29; i >= 0; i--) {
            const bit = (x >> i) & 1;
            const want = 1 - bit;
            if (trie[node * 2 + want] !== 0) {
                result |= (1 << i);
                node = trie[node * 2 + want];
            } else {
                node = trie[node * 2 + bit];
            }
        }
        return result;
    };

    const answer = new Array(q);
    let ni = 0;
    for (const qi of qIdx) {
        const [x, m] = queries[qi];
        while (ni < nums.length && nums[ni] <= m) {
            insert(nums[ni++]);
        }
        answer[qi] = ni === 0 ? -1 : queryMax(x);
    }
    return answer;
};
