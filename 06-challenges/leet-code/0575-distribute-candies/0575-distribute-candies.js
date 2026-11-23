/**
 * @param {number[]} candyType
 * @return {number}
 */
var distributeCandies = function (candyType) {
    return Math.min(candyType.length / 2, new Set(candyType).size);
};
