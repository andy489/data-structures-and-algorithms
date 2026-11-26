// https://leetcode.com/problems/license-key-formatting/

var licenseKeyFormatting = function(s, k) {
    const clean = s.replace(/-/g, '').toUpperCase();
    const firstLen = clean.length % k;
    const parts = [];
    if (firstLen > 0) {
        parts.push(clean.slice(0, firstLen));
    }
    for (let i = firstLen; i < clean.length; i += k) {
        parts.push(clean.slice(i, i + k));
    }
    return parts.join('-');
};
