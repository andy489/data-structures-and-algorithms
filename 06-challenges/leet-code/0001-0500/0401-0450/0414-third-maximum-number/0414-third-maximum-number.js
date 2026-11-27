// https://leetcode.com/problems/third-maximum-number/

var thirdMax = function(nums) {
    let first = -Infinity, second = -Infinity, third = -Infinity;
    for (const num of nums) {
        if (num === first || num === second || num === third) {
            continue;
        }
        if (num > first) {
            [third, second, first] = [second, first, num];
        } else if (num > second) {
            [third, second] = [second, num];
        } else if (num > third) {
            third = num;
        }
    }
    return third === -Infinity ? first : third;
};
