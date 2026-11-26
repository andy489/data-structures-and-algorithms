// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

var constructDistancedSequence = function(n) {
    const size = 2 * n - 1;
    const result = new Array(size).fill(0);
    const used = new Array(n + 1).fill(false);

    const backtrack = (pos) => {
        if (pos === size) {
            return true;
        }
        if (result[pos] !== 0) {
            return backtrack(pos + 1);
        }
        for (let v = n; v >= 1; v--) {
            if (used[v]) {
                continue;
            }
            if (v === 1) {
                result[pos] = 1;
                used[1] = true;
                if (backtrack(pos + 1)) {
                    return true;
                }
                result[pos] = 0;
                used[1] = false;
            } else {
                const second = pos + v;
                if (second < size && result[second] === 0) {
                    result[pos] = v;
                    result[second] = v;
                    used[v] = true;
                    if (backtrack(pos + 1)) {
                        return true;
                    }
                    result[pos] = 0;
                    result[second] = 0;
                    used[v] = false;
                }
            }
        }
        return false;
    };

    backtrack(0);
    return result;
};
