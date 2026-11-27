// https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/

var boxDelivering = function(boxes, portsCount, maxBoxes, maxWeight) {
    const n = boxes.length;
    const diff = new Array(n).fill(0);
    for (let i = 1; i < n; i++) {
        diff[i] = boxes[i][0] !== boxes[i - 1][0] ? 1 : 0;
    }
    const dp = new Array(n + 1).fill(0);
    let l = 0, weight = 0, trips = 0;
    for (let r = 0; r < n; r++) {
        weight += boxes[r][1];
        if (r > 0) {
            trips += diff[r];
        }
        while (r - l + 1 > maxBoxes || weight > maxWeight) {
            weight -= boxes[l][1];
            if (l + 1 <= r) {
                trips -= diff[l + 1];
            }
            l++;
        }
        dp[r + 1] = dp[l] + trips + 2;
        if (r > 0 && boxes[r][0] === boxes[r - 1][0]) {
            dp[r + 1] = Math.min(dp[r + 1], dp[r]);
        }
    }
    return dp[n];
};
