// https://leetcode.com/problems/jump-game-iii/

var canReach = function(arr, start) {
    const n = arr.length, visited = new Set();
    const q = [start];
    while (q.length) {
        const i = q.shift();
        if (visited.has(i)) continue;
        visited.add(i);
        if (arr[i] === 0) return true;
        for (const nxt of [i + arr[i], i - arr[i]]) {
            if (nxt >= 0 && nxt < n && !visited.has(nxt)) q.push(nxt);
        }
    }
    return false;
};
