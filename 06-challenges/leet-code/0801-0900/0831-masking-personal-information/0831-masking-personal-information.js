// https://leetcode.com/problems/masking-personal-information/

var maskPII = function(s) {
    s = s.toLowerCase();
    const at = s.indexOf('@');
    if (at >= 0) {
        return s[0] + '*****' + s.slice(at - 1);
    }
    const digits = s.split('').filter(c => /\d/.test(c)).join('');
    const last4 = digits.slice(-4);
    let prefix = '***-***-';
    const extra = digits.length - 10;
    if (extra > 0) { prefix = '+' + '*'.repeat(extra) + '-' + prefix; }
    return prefix + last4;
};
