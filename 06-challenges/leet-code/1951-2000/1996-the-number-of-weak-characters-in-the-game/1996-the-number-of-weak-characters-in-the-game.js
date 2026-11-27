// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
/**
 * @param {number[][]} properties
 * @return {number}
 */
var numberOfWeakCharacters = function(properties) {
    properties.sort((a, b) => a[0] !== b[0] ? b[0] - a[0] : a[1] - b[1]);
    let maxDef = 0, weak = 0;
    for (const [, d] of properties) {
        if (d < maxDef) {
            weak++;
        }
        if (d > maxDef) {
            maxDef = d;
        }
    }
    return weak;
};
