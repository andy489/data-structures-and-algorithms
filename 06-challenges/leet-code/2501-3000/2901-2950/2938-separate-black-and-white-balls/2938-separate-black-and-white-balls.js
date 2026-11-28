// https://leetcode.com/problems/separate-black-and-white-balls/

var minimumSteps = function(s) {
    let moves = 0n;
    let whites = 0;
    for (const c of s) {
        if (c === '0') {
            whites++;
        } else {
            moves += BigInt(whites);
        }
    }
    return moves;
};
