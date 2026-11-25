// https://leetcode.com/problems/camelcase-matching/

var camelMatch = function(queries, pattern) {
    const matches = query => {
        let j = 0;
        for (const c of query) {
            if (j < pattern.length && c === pattern[j]) j++;
            else if (c >= 'A' && c <= 'Z') return false;
        }
        return j === pattern.length;
    };
    return queries.map(matches);
};
