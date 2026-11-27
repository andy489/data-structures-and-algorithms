// https://leetcode.com/problems/k-th-symbol-in-grammar/

var kthGrammar = function(n, k) {
    if (n === 1) return 0;
    const parent = kthGrammar(n - 1, Math.ceil(k / 2));
    return k % 2 === 1 ? parent : 1 - parent;
};
