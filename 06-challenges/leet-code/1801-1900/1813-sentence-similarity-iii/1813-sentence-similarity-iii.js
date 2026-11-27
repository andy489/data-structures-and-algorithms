// https://leetcode.com/problems/sentence-similarity-iii/

var areSentencesSimilar = function(sentence1, sentence2) {
    const w1 = sentence1.split(' '), w2 = sentence2.split(' ');
    let i = 0, j1 = w1.length - 1, j2 = w2.length - 1;
    while (i <= j1 && i <= j2 && w1[i] === w2[i]) i++;
    while (j1 >= i && j2 >= i && w1[j1] === w2[j2]) { j1--; j2--; }
    return i > j1 || i > j2;
};
