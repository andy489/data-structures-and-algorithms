// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

/**
 * @param {string} word
 * @param {number} k
 * @return {number}
 */
var countOfSubstrings = function (word, k) {
    const VOWELS = new Set(['a', 'e', 'i', 'o', 'u']);

    function atLeast(minK) {
        const vowelCount = new Map();
        let consonants = 0;
        let result = 0n;
        let l = 0;
        const n = word.length;
        for (let r = 0; r < n; r++) {
            const c = word[r];
            if (VOWELS.has(c)) {
                vowelCount.set(c, (vowelCount.get(c) || 0) + 1);
            } else {
                consonants++;
            }
            while (vowelCount.size === 5 && consonants >= minK) {
                result += BigInt(n - r);
                const lc = word[l];
                if (VOWELS.has(lc)) {
                    const cnt = vowelCount.get(lc) - 1;
                    if (cnt === 0) {
                        vowelCount.delete(lc);
                    } else {
                        vowelCount.set(lc, cnt);
                    }
                } else {
                    consonants--;
                }
                l++;
            }
        }
        return result;
    }

    return Number(atLeast(k) - atLeast(k + 1));
};
