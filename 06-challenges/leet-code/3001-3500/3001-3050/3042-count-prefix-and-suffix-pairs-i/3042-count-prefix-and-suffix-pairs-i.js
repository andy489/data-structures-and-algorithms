// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

var countPrefixSuffixPairs = function(words) {
    let count = 0;
    for (let i = 0; i < words.length; i++) {
        for (let j = i+1; j < words.length; j++) {
            if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) count++;
        }
    }
    return count;
};
