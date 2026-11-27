// https://leetcode.com/problems/queries-on-a-permutation-with-key/

var processQueries = function(queries, m) {
    const perm = Array.from({length: m}, (_, i) => i + 1);
    return queries.map(q => {
        const pos = perm.indexOf(q);
        perm.splice(pos, 1);
        perm.unshift(q);
        return pos + 1;
    });
};
