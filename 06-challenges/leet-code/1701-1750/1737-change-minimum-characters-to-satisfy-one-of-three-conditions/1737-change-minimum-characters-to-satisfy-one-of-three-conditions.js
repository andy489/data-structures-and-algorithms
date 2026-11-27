// https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

var minCharacters = function(a, b) {
    const fa = new Array(26).fill(0), fb = new Array(26).fill(0);
    for (const c of a) { fa[c.charCodeAt(0) - 97]++; }
    for (const c of b) { fb[c.charCodeAt(0) - 97]++; }
    const na = a.length, nb = b.length;
    let ans = na + nb;

    // Condition 3
    for (let i = 0; i < 26; i++) {
        ans = Math.min(ans, (na - fa[i]) + (nb - fb[i]));
    }

    // Prefix sums
    const prefA = fa.slice(), prefB = fb.slice();
    for (let i = 1; i < 26; i++) {
        prefA[i] += prefA[i - 1];
        prefB[i] += prefB[i - 1];
    }

    // Conditions 1 & 2
    for (let c = 1; c < 26; c++) {
        ans = Math.min(ans, (na - prefA[c - 1]) + prefB[c - 1]);
        ans = Math.min(ans, (nb - prefB[c - 1]) + prefA[c - 1]);
    }
    return ans;
};
