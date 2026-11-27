// https://leetcode.com/problems/groups-of-special-equivalent-strings/

var numSpecialEquivGroups = function(words) {
    const key = w => {
        const even = [...w].filter((_, i) => i % 2 === 0).sort().join('');
        const odd = [...w].filter((_, i) => i % 2 === 1).sort().join('');
        return even + ',' + odd;
    };
    return new Set(words.map(key)).size;
};
