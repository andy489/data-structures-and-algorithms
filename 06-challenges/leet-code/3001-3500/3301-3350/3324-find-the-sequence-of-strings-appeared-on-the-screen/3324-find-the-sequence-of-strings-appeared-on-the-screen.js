// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/

/**
 * @param {string} target
 * @return {string[]}
 */
var stringSequence = function(target) {
    const result = [];
    const current = [];
    for (const c of target) {
        current.push('a');
        result.push(current.join(''));
        while (current[current.length - 1] !== c) {
            current[current.length - 1] = String.fromCharCode(current[current.length - 1].charCodeAt(0) + 1);
            result.push(current.join(''));
        }
    }
    return result;
};
