// https://leetcode.com/problems/majority-element-ii/

// Solution: Boyer-Moore Voting (2 Candidates) — O(n) time, O(1) space
var majorityElement = function(nums) {
    let cand1 = 0, cnt1 = 0, cand2 = 1, cnt2 = 0;

    for (const num of nums) {
        if (num === cand1) cnt1++;
        else if (num === cand2) cnt2++;
        else if (cnt1 === 0) { cand1 = num; cnt1 = 1; }
        else if (cnt2 === 0) { cand2 = num; cnt2 = 1; }
        else { cnt1--; cnt2--; }
    }

    cnt1 = cnt2 = 0;
    for (const num of nums) {
        if (num === cand1) cnt1++;
        else if (num === cand2) cnt2++;
    }

    const result = [];
    if (cnt1 > nums.length / 3) result.push(cand1);
    if (cnt2 > nums.length / 3) result.push(cand2);
    return result;
};
