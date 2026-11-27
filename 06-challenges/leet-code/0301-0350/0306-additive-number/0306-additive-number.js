// https://leetcode.com/problems/additive-number/

var isAdditiveNumber = function(num) {
    const add = (a, b) => (BigInt(a) + BigInt(b)).toString();
    const check = (s1, s2, rest) => {
        if (s1.length > 1 && s1[0] === '0') return false;
        if (s2.length > 1 && s2[0] === '0') return false;
        const sum = add(s1, s2);
        if (!rest.startsWith(sum)) return false;
        if (rest === sum) return true;
        return check(s2, sum, rest.slice(sum.length));
    };
    const n = num.length;
    for (let i = 1; i <= Math.floor(n / 2); i++) {
        for (let j = i + 1; j < n; j++) {
            if (check(num.slice(0, i), num.slice(i, j), num.slice(j))) return true;
        }
    }
    return false;
};
