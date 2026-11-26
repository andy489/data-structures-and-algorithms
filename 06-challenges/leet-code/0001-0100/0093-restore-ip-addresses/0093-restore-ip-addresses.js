// https://leetcode.com/problems/restore-ip-addresses/

var restoreIpAddresses = function(s) {
    const result = [];
    function backtrack(start, parts) {
        if (parts.length === 4) {
            if (start === s.length) result.push(parts.join('.'));
            return;
        }
        const remaining = s.length - start;
        const segmentsLeft = 4 - parts.length;
        if (remaining < segmentsLeft || remaining > segmentsLeft * 3) return;
        for (let len = 1; len <= 3 && start + len <= s.length; len++) {
            const seg = s.slice(start, start + len);
            if (seg.length > 1 && seg[0] === '0') break;
            if (parseInt(seg) > 255) break;
            parts.push(seg);
            backtrack(start + len, parts);
            parts.pop();
        }
    }
    backtrack(0, []);
    return result;
};
