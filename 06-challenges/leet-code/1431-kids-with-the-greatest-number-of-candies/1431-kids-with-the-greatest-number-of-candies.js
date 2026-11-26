// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

var kidsWithCandies = function(candies, extraCandies) {
    const max = Math.max(...candies);
    return candies.map(c => c + extraCandies >= max);
};
