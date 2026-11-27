// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

var findTheWinner = function(n, k) {
    let pos = 0;
    for (let i = 2; i <= n; i++) {
        pos = (pos + k) % i;
    }
    return pos + 1;
};
