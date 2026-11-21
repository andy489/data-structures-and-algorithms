// https://leetcode.com/problems/word-ladder/

// Solution 1: BFS — O(n·L·26) time, O(n·L) space
var ladderLength = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return 0;
    const queue = [[beginWord, 1]];
    wordSet.delete(beginWord);
    for (const [word, steps] of queue) {
        for (let i = 0; i < word.length; i++) {
            for (let c = 97; c <= 122; c++) {
                const ch = String.fromCharCode(c);
                if (ch === word[i]) continue;
                const nxt = word.slice(0, i) + ch + word.slice(i + 1);
                if (nxt === endWord) return steps + 1;
                if (wordSet.has(nxt)) {
                    wordSet.delete(nxt);
                    queue.push([nxt, steps + 1]);
                }
            }
        }
    }
    return 0;
};

// Solution 2: Bidirectional BFS — O(n·L·26) time, O(n·L) space
var ladderLength2 = function(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return 0;
    let frontA = new Set([beginWord]), frontB = new Set([endWord]);
    wordSet.delete(beginWord);
    wordSet.delete(endWord);
    let steps = 1;
    while (frontA.size > 0 && frontB.size > 0) {
        if (frontA.size > frontB.size) [frontA, frontB] = [frontB, frontA];
        steps++;
        const nxt = new Set();
        for (const word of frontA) {
            for (let i = 0; i < word.length; i++) {
                for (let c = 97; c <= 122; c++) {
                    const ch = String.fromCharCode(c);
                    if (ch === word[i]) continue;
                    const neighbor = word.slice(0, i) + ch + word.slice(i + 1);
                    if (frontB.has(neighbor)) return steps;
                    if (wordSet.has(neighbor)) {
                        wordSet.delete(neighbor);
                        nxt.add(neighbor);
                    }
                }
            }
        }
        frontA = nxt;
    }
    return 0;
};
