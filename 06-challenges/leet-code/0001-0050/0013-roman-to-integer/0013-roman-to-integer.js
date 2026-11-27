// https://leetcode.com/problems/roman-to-integer/

var romanToInt = function(s) {
    const T = { I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000 };
    let res = T[s[s.length - 1]];

    for (let i = s.length - 2; i >= 0; i--) {
        if (T[s[i]] < T[s[i + 1]]) {
            res -= T[s[i]];
        } else {
            res += T[s[i]];
        }
    }

    return res;
};
