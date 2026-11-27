// https://leetcode.com/problems/maximum-repeating-substring/

var maxRepeating = function(sequence, word) {
    let k = 0;
    let repeated = word;
    while (sequence.includes(repeated)) {
        k++;
        repeated += word;
    }
    return k;
};
