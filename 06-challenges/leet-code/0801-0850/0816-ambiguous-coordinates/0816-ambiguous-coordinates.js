// https://leetcode.com/problems/ambiguous-coordinates/

var ambiguousCoordinates = function(s) {
    const digits = s.slice(1, -1);
    function generate(t) {
        const res = [];
        if (!t.startsWith('0') || t === '0') { res.push(t); }
        for (let i = 1; i < t.length; i++) {
            const dec = t.slice(0, i) + '.' + t.slice(i);
            if ((!dec.startsWith('0') || dec.startsWith('0.')) && !dec.endsWith('0')) {
                res.push(dec);
            }
        }
        return res;
    }
    const result = [];
    for (let i = 1; i < digits.length; i++) {
        for (const l of generate(digits.slice(0, i))) {
            for (const r of generate(digits.slice(i))) {
                result.push(`(${l}, ${r})`);
            }
        }
    }
    return result;
};
