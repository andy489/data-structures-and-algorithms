// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
var findWinners = function (matches) {
    const losses = new Map();
    for (const [winner, loser] of matches) {
        if (!losses.has(winner)) {
            losses.set(winner, 0);
        }
        losses.set(loser, (losses.get(loser) || 0) + 1);
    }
    const noLoss = [];
    const oneLoss = [];
    for (const [player, count] of losses) {
        if (count === 0) {
            noLoss.push(player);
        } else if (count === 1) {
            oneLoss.push(player);
        }
    }
    noLoss.sort((a, b) => a - b);
    oneLoss.sort((a, b) => a - b);
    return [noLoss, oneLoss];
};
