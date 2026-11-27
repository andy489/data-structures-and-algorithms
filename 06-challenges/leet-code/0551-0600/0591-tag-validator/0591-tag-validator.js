// https://leetcode.com/problems/tag-validator/
var isValid = function(code) {
    const tagStack = [];
    let i = 0;
    const n = code.length;
    const isValidTag = (tag) => tag.length >= 1 && tag.length <= 9 && /^[A-Z]+$/.test(tag);
    while (i < n) {
        if (i > 0 && tagStack.length === 0) {
            return false;
        }
        if (code.startsWith('<![CDATA[', i)) {
            const end = code.indexOf(']]>', i + 9);
            if (end === -1) {
                return false;
            }
            i = end + 3;
        } else if (code.startsWith('</', i)) {
            const end = code.indexOf('>', i);
            if (end === -1) {
                return false;
            }
            const tag = code.slice(i + 2, end);
            if (!isValidTag(tag)) {
                return false;
            }
            if (tagStack.length === 0 || tagStack[tagStack.length - 1] !== tag) {
                return false;
            }
            tagStack.pop();
            i = end + 1;
        } else if (code[i] === '<') {
            const end = code.indexOf('>', i);
            if (end === -1) {
                return false;
            }
            const tag = code.slice(i + 1, end);
            if (!isValidTag(tag)) {
                return false;
            }
            tagStack.push(tag);
            i = end + 1;
        } else {
            i++;
        }
    }
    return tagStack.length === 0;
};
