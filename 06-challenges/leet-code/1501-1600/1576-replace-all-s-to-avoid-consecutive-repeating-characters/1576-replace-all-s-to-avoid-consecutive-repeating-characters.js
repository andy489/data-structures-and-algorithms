// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

var modifyString = function(s) {
    const arr = s.split('');
    const n = arr.length;
    for (let i = 0; i < n; i++) {
        if (arr[i] === '?') {
            for (const c of ['a', 'b', 'c']) {
                if ((i === 0 || arr[i - 1] !== c) && (i === n - 1 || arr[i + 1] !== c)) {
                    arr[i] = c;
                    break;
                }
            }
        }
    }
    return arr.join('');
};
