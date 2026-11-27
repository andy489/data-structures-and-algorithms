// https://leetcode.com/problems/minimum-window-substring/

var minWindow = function(s, t) {
    if (s.length < t.length) return "";
    const need = new Map();
    for (const c of t) need.set(c, (need.get(c) || 0) + 1);
    const window = new Map();
    const required = need.size;
    let formed = 0, left = 0, minLen = Infinity, minLeft = 0;
    for (let right = 0; right < s.length; right++) {
        const c = s[right];
        window.set(c, (window.get(c) || 0) + 1);
        if (need.has(c) && window.get(c) === need.get(c)) formed++;
        while (formed === required) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minLeft = left;
            }
            const lc = s[left++];
            window.set(lc, window.get(lc) - 1);
            if (need.has(lc) && window.get(lc) < need.get(lc)) formed--;
        }
    }
    return minLen === Infinity ? "" : s.substring(minLeft, minLeft + minLen);
};
