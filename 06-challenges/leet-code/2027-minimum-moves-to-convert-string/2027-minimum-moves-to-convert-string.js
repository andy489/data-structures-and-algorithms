// https://leetcode.com/problems/minimum-moves-to-convert-string/

// Solution: Greedy — O(n) time, O(1) space
var minimumMoves = function(s) {
    let moves = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === 'X') { moves++; i += 2; }
    }
    return moves;
};
