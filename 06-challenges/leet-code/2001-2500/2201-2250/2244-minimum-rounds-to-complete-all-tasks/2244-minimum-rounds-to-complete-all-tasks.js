// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

/**
 * @param {number[]} tasks
 * @return {number}
 */
var minimumRounds = function (tasks) {
    const freq = new Map();
    for (const t of tasks) {
        freq.set(t, (freq.get(t) || 0) + 1);
    }
    let rounds = 0;
    for (const cnt of freq.values()) {
        if (cnt === 1) {
            return -1;
        }
        rounds += Math.ceil(cnt / 3);
    }
    return rounds;
};
