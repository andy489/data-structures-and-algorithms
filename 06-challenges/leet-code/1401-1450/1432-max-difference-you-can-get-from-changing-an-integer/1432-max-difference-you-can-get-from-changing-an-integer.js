// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

var maxDiff = function(num) {
    let s = String(num), maxS = s, minS = s;
    for (const c of s) { if (c !== '9') { maxS = s.replace(new RegExp(c, 'g'), '9'); break; } }
    if (s[0] !== '1') { minS = s.replace(new RegExp(s[0], 'g'), '1'); }
    else {
        for (let i = 1; i < s.length; i++) {
            if (s[i] !== '0' && s[i] !== '1') { minS = s.replace(new RegExp(s[i], 'g'), '0'); break; }
        }
    }
    return +maxS - +minS;
};
