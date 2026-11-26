// https://leetcode.com/problems/combinations/

var combine = function(n, k) {
    const result = [];

    function backtrack(start, current) {
        if (current.length === k) {
            result.push([...current]);
            return;
        }
        const need = k - current.length;
        for (let i = start; i <= n - need + 1; i++) {
            current.push(i);
            backtrack(i + 1, current);
            current.pop();
        }
    }

    backtrack(1, []);
    return result;
};
