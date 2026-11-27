// https://leetcode.com/problems/replace-words/

var replaceWords = function(dictionary, sentence) {
    const rootSet = new Set(dictionary);
    return sentence.split(' ').map(word => {
        for (let len = 1; len <= word.length; len++) {
            const prefix = word.substring(0, len);
            if (rootSet.has(prefix)) return prefix;
        }
        return word;
    }).join(' ');
};
