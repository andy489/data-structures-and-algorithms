// https://leetcode.com/problems/string-without-aaa-or-bbb/

var strWithout3a3b = function(a, b) {
    const res = [];
    while (a || b) {
        if (a > b) {
            res.push('a'); a--;
            if (a > b) { res.push('a'); a--; }
        } else {
            res.push('b'); b--;
            if (b > a) { res.push('b'); b--; }
        }
    }
    return res.join('');
};
