// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

var splitIntoFibonacci = function(num) {
    const seq = [];
    function backtrack(idx) {
        if (idx === num.length && seq.length >= 3) { return true; }
        for (let end = idx + 1; end <= num.length; end++) {
            const part = num.slice(idx, end);
            if (part.length > 1 && part[0] === '0') { break; }
            const val = parseInt(part);
            if (val > 2147483647) { break; }
            if (seq.length >= 2 && val !== seq[seq.length-1] + seq[seq.length-2]) {
                if (val > seq[seq.length-1] + seq[seq.length-2]) { break; }
                continue;
            }
            seq.push(val);
            if (backtrack(end)) { return true; }
            seq.pop();
        }
        return false;
    }
    backtrack(0);
    return seq;
};
