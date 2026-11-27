// https://leetcode.com/problems/password-strength/
/**
 * @param {string} password
 * @return {number}
 */
var passwordStrength = function(password) {
    const seen = new Set();
    let strength = 0;
    for (const c of password) {
        if (!seen.has(c)) {
            seen.add(c);
            if (c >= 'a' && c <= 'z') {
                strength += 1;
            } else if (c >= 'A' && c <= 'Z') {
                strength += 2;
            } else if (c >= '0' && c <= '9') {
                strength += 3;
            } else if ('!@#$'.includes(c)) {
                strength += 5;
            }
        }
    }
    return strength;
};
