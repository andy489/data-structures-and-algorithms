// https://leetcode.com/problems/most-profit-assigning-work/

var maxProfitAssignment = function(difficulty, profit, worker) {
    const jobs = difficulty.map((d, i) => [d, profit[i]]).sort((a, b) => a[0] - b[0]);
    worker.sort((a, b) => a - b);
    let total = 0, maxProfit = 0, j = 0;
    for (const ability of worker) {
        while (j < jobs.length && jobs[j][0] <= ability) {
            maxProfit = Math.max(maxProfit, jobs[j][1]);
            j++;
        }
        total += maxProfit;
    }
    return total;
};
