// https://leetcode.com/problems/find-and-replace-in-string/

var findReplaceString = function(s, indices, sources, targets) {
    const ops = new Map();
    for (let i = 0; i < indices.length; i++) {
        if (s.startsWith(sources[i], indices[i])) {
            ops.set(indices[i], i);
        }
    }
    let result = '', i = 0;
    while (i < s.length) {
        if (ops.has(i)) {
            const op = ops.get(i);
            result += targets[op];
            i += sources[op].length;
        } else {
            result += s[i++];
        }
    }
    return result;
};
