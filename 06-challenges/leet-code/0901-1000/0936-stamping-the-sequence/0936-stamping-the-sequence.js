// https://leetcode.com/problems/stamping-the-sequence/

var movesToStamp = function(stamp, target) {
    const t = target.split(''), s = stamp.split('');
    const n = t.length, m = s.length;
    const result = [];
    let stars = 0;
    const tryStamp = i => {
        let covered = 0;
        for (let j = 0; j < m; j++) {
            if (t[i+j] === '?') continue;
            if (t[i+j] !== s[j]) return 0;
            covered++;
        }
        return covered;
    };
    while (stars < n) {
        let progress = false;
        for (let i = 0; i <= n - m; i++) {
            const c = tryStamp(i);
            if (c > 0) {
                stars += c; progress = true; result.push(i);
                for (let j = i; j < i + m; j++) t[j] = '?';
            }
        }
        if (!progress) return [];
    }
    return result.reverse();
};
