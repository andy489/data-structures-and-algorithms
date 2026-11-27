// https://leetcode.com/problems/mirror-reflection/

var mirrorReflection = function(p, q) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const g = gcd(p, q);
    const m = p / g, n = q / g;
    if (m % 2 === 0) return 2;
    if (n % 2 === 0) return 0;
    return 1;
};
