// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
var maximumCandies = function (candies, k) {
    const canAllocate = m => {
        let piles = 0n;
        for (const c of candies) {
            piles += BigInt(Math.floor(c / m));
        }
        return piles >= k;
    };
    let lo = 1, hi = Math.max(...candies);
    let answer = 0;
    while (lo <= hi) {
        const mid = Math.floor((lo + hi) / 2);
        if (canAllocate(mid)) {
            answer = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return answer;
};
