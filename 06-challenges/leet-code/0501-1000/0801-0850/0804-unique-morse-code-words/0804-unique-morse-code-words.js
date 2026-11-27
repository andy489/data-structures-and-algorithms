// https://leetcode.com/problems/unique-morse-code-words/

var uniqueMorseRepresentations = function(words) {
    const morse = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
    const seen = new Set();
    for (const word of words) {
        seen.add(word.split('').map(c => morse[c.charCodeAt(0) - 97]).join(''));
    }
    return seen.size;
};
