// https://leetcode.com/problems/stone-removal-game/

var canAliceWin = function(n) {
    let toRemove = 10, aliceTurn = true;
    while (n >= toRemove) {
        n -= toRemove;
        toRemove--;
        aliceTurn = !aliceTurn;
    }
    return !aliceTurn;
};
