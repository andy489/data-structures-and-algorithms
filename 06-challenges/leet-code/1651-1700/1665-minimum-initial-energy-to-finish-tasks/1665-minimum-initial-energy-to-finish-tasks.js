// https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/

var minimumEffort = function(tasks) {
    tasks.sort((a, b) => (a[1] - a[0]) - (b[1] - b[0]));
    let energy = 0;
    for (const [actual, minimum] of tasks) {
        energy = Math.max(energy + actual, minimum);
    }
    return energy;
};
