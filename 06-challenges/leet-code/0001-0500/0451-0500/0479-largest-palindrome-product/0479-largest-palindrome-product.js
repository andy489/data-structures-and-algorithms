// https://leetcode.com/problems/largest-palindrome-product/

var largestPalindrome = function(n) {
    if (n === 1) return 9;
    const maxVal = Math.pow(10, n) - 1;
    const minVal = Math.pow(10, n - 1);
    for (let upper = maxVal; upper >= minVal; upper--) {
        const s = upper.toString();
        const palindrome = BigInt(s + s.split('').reverse().join(''));
        let divisor = BigInt(maxVal);
        while (divisor * divisor >= palindrome) {
            if (palindrome % divisor === 0n) {
                const other = palindrome / divisor;
                if (other >= BigInt(minVal) && other <= BigInt(maxVal)) {
                    return Number(palindrome % 1337n);
                }
            }
            divisor--;
        }
    }
    return 0;
};
