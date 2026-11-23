// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/

var findKthNumber = function(n, k) {
    function countSteps(prefix, nextPrefix) {
        let steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }

    let curr = 1;
    k--;
    while (k > 0) {
        const steps = countSteps(curr, curr + 1);
        if (steps <= k) {
            curr++;
            k -= steps;
        } else {
            curr *= 10;
            k--;
        }
    }
    return curr;
};
