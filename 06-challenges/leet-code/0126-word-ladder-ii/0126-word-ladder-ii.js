// https://leetcode.com/problems/word-ladder-ii/

// Solution: BFS DAG + DFS Backtrack — O(n·L·26 + P) time, O(n·L) space
var findLadders = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    const ans = [];
    if (!wordSet.has(endWord)) return ans;

    const parents = new Map();
    let currentLevel = new Set([beginWord]);
    let found = false;

    while (currentLevel.size > 0 && !found) {
        for (const w of currentLevel) wordSet.delete(w);
        const nextLevel = new Set();
        for (const word of currentLevel) {
            for (let i = 0; i < word.length; i++) {
                for (let c = 97; c <= 122; c++) {
                    const ch = String.fromCharCode(c);
                    if (ch === word[i]) continue;
                    const nxt = word.slice(0, i) + ch + word.slice(i + 1);
                    if (wordSet.has(nxt)) {
                        nextLevel.add(nxt);
                        if (!parents.has(nxt)) parents.set(nxt, []);
                        parents.get(nxt).push(word);
                        if (nxt === endWord) found = true;
                    }
                }
            }
        }
        currentLevel = nextLevel;
    }

    if (!found) return ans;

    function dfs(word, path) {
        if (word === beginWord) {
            ans.push([...path].reverse());
            return;
        }
        for (const parent of (parents.get(word) ?? [])) {
            path.push(parent);
            dfs(parent, path);
            path.pop();
        }
    }

    dfs(endWord, [endWord]);
    return ans;
};
