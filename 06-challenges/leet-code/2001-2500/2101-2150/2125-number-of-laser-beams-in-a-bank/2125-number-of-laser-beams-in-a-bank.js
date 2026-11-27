// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
var numberOfBeams = function(bank) {
    let result = 0, prev = 0;
    for (const row of bank) {
        let count = 0;
        for (const c of row) {
            if (c === '1') count++;
        }
        if (count > 0) {
            result += prev * count;
            prev = count;
        }
    }
    return result;
};
