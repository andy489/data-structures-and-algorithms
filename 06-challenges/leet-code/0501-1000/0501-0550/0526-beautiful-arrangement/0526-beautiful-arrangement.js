// https://leetcode.com/problems/beautiful-arrangement/

var countArrangement = function(n) {
    let count = 0;
    const visited = new Array(n + 1).fill(false);
    function backtrack(pos) {
        if (pos > n) { count++; return; }
        for (let num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos === 0 || pos % num === 0)) {
                visited[num] = true;
                backtrack(pos + 1);
                visited[num] = false;
            }
        }
    }
    backtrack(1);
    return count;
};
