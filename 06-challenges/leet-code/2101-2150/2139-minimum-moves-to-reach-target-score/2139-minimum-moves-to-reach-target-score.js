// https://leetcode.com/problems/minimum-moves-to-reach-target-score/
var minMoves = function(target, maxDoubles) {
    let moves = 0;
    while (target > 1 && maxDoubles > 0) {
        if (target % 2 === 1) {
            target--;
            moves++;
        } else {
            target = Math.floor(target / 2);
            moves++;
            maxDoubles--;
        }
    }
    moves += target - 1;
    return moves;
};
