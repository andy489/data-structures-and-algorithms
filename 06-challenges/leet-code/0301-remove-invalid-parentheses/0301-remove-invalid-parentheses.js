// https://leetcode.com/problems/remove-invalid-parentheses/

// Solution: BFS — O(2^n) time, O(2^n) space
var removeInvalidParentheses = function(s) {
    const result = [];
    const visited = new Set([s]);
    let queue = [s];
    let found = false;
    while (queue.length && !found) {
        const nextLevel = [];
        for (const cur of queue) {
            if (isValid(cur)) {
                result.push(cur);
                found = true;
            }
            if (!found) {
                for (let i = 0; i < cur.length; i++) {
                    if (cur[i] !== '(' && cur[i] !== ')') continue;
                    const nxt = cur.slice(0, i) + cur.slice(i + 1);
                    if (!visited.has(nxt)) {
                        visited.add(nxt);
                        nextLevel.push(nxt);
                    }
                }
            }
        }
        queue = nextLevel;
    }
    return result;
};

function isValid(s) {
    let count = 0;
    for (const c of s) {
        if (c === '(') count++;
        else if (c === ')') {
            if (--count < 0) return false;
        }
    }
    return count === 0;
}
