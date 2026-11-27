// https://leetcode.com/problems/count-indices-with-opposite-parity/
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var countIndices = function(nums) {
    let oddCount = 0, evenCount = 0;
    for (const v of nums) {
        if (v % 2 === 0) { evenCount++; } else { oddCount++; }
    }
    const answer = [];
    let seenOdd = 0, seenEven = 0;
    for (const v of nums) {
        if (v % 2 === 0) { seenEven++; } else { seenOdd++; }
        const remainingOdd = oddCount - seenOdd;
        const remainingEven = evenCount - seenEven;
        answer.push(v % 2 === 0 ? remainingOdd : remainingEven);
    }
    return answer;
};
