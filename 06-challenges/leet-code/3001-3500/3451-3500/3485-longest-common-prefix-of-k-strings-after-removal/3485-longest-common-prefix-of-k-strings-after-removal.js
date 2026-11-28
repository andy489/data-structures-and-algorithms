// https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/

var longestCommonPrefix = function(words, k) {
    const n = words.length;
    // Trie as object with count
    const root = {cnt: 0};

    const insert = (word, delta) => {
        let node = root;
        node.cnt += delta;
        for (const c of word) {
            if (!node[c]) node[c] = {cnt: 0};
            node = node[c];
            node.cnt += delta;
        }
    };

    const query = (k) => {
        let node = root;
        let depth = 0;
        while (true) {
            let found = false;
            for (let i = 0; i < 26; i++) {
                const c = String.fromCharCode(97 + i);
                if (node[c] && node[c].cnt >= k) {
                    node = node[c];
                    depth++;
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }
        return depth;
    };

    for (const word of words) insert(word, 1);

    const answer = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        if (n - 1 < k) continue;
        insert(words[i], -1);
        answer[i] = query(k);
        insert(words[i], 1);
    }
    return answer;
};
