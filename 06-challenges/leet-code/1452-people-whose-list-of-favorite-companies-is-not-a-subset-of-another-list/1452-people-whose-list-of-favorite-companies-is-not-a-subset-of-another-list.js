// https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

var peopleIndexes = function(favoriteCompanies) {
    const sets = favoriteCompanies.map(fc => new Set(fc));
    return sets.map((s, i) => i).filter(i =>
        !sets.some((other, j) => j !== i && other.size >= sets[i].size && [...sets[i]].every(c => other.has(c)))
    );
};
