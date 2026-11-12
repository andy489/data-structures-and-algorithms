// https://leetcode.com/problems/group-anagrams/

var groupAnagrams = function(strs) {
    const grouped = new Map();
    for (const s of strs) {
        const key = s.split('').sort().join('');
        if (!grouped.has(key)) {
            grouped.set(key, []);
        }
        grouped.get(key).push(s);
    }
    return [...grouped.values()];
};
