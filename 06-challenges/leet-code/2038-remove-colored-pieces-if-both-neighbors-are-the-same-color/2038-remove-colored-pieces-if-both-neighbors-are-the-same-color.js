// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

// Solution: Count Runs — O(n) time, O(1) space
var winnerOfGame = function(colors) {
    let alice = 0, bob = 0;
    for (let i = 1; i < colors.length - 1; i++) {
        if (colors[i-1] === colors[i] && colors[i] === colors[i+1]) {
            if (colors[i] === 'A') alice++;
            else bob++;
        }
    }
    return alice > bob;
};
