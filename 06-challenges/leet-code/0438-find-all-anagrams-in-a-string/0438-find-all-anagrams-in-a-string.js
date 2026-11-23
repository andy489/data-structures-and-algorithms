// https://leetcode.com/problems/find-all-anagrams-in-a-string/

var findAnagrams = function(s, p) {
    const result = [];
    if (s.length < p.length) return result;
    const pCount = new Array(26).fill(0);
    const windowCount = new Array(26).fill(0);
    for (const c of p) pCount[c.charCodeAt(0) - 97]++;
    for (let i = 0; i < p.length; i++) windowCount[s.charCodeAt(i) - 97]++;
    let matches = pCount.filter((v, i) => v === windowCount[i]).length;
    for (let right = p.length; right < s.length; right++) {
        if (matches === 26) result.push(right - p.length);
        const addIdx = s.charCodeAt(right) - 97;
        if (windowCount[addIdx] === pCount[addIdx]) matches--;
        windowCount[addIdx]++;
        if (windowCount[addIdx] === pCount[addIdx]) matches++;
        const removeIdx = s.charCodeAt(right - p.length) - 97;
        if (windowCount[removeIdx] === pCount[removeIdx]) matches--;
        windowCount[removeIdx]--;
        if (windowCount[removeIdx] === pCount[removeIdx]) matches++;
    }
    if (matches === 26) result.push(s.length - p.length);
    return result;
};
