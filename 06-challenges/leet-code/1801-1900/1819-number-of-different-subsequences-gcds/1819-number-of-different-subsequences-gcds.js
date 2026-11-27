// https://leetcode.com/problems/number-of-different-subsequences-gcds/

var countDifferentSubsequencesGCDs = function(nums) {
    function gcd(a, b) {
        while (b) { [a, b] = [b, a % b]; }
        return a;
    }

    const maxVal = Math.max(...nums);
    const present = new Set(nums);
    let ans = 0;

    for (let g = 1; g <= maxVal; g++) {
        let cur = 0;
        for (let multiple = g; multiple <= maxVal; multiple += g) {
            if (present.has(multiple)) {
                cur = gcd(cur, multiple);
                if (cur === g) {
                    ans++;
                    break;
                }
            }
        }
    }
    return ans;
};
