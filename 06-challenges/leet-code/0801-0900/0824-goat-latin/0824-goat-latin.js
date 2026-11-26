// https://leetcode.com/problems/goat-latin/

var toGoatLatin = function(sentence) {
    const vowels = new Set('aeiouAEIOU');
    return sentence.split(' ').map((w, i) => {
        const base = vowels.has(w[0]) ? w : w.slice(1) + w[0];
        return base + 'ma' + 'a'.repeat(i + 1);
    }).join(' ');
};
