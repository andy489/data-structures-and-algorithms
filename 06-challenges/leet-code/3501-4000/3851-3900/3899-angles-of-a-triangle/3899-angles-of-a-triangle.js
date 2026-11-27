// https://leetcode.com/problems/angles-of-a-triangle/
/**
 * @param {number[]} sides
 * @return {number[]}
 */
var anglesOfTriangle = function(sides) {
    const [a, b, c] = sides;

    // Check triangle inequality (positive area)
    if (a + b <= c || a + c <= b || b + c <= a) {
        return [];
    }

    // Law of cosines
    const angleA = (Math.acos((b * b + c * c - a * a) / (2.0 * b * c)) * 180) / Math.PI;
    const angleB = (Math.acos((a * a + c * c - b * b) / (2.0 * a * c)) * 180) / Math.PI;
    const angleC = 180.0 - angleA - angleB;

    return [angleA, angleB, angleC].sort((x, y) => x - y);
};
