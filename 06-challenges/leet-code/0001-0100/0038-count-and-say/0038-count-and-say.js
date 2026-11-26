// https://leetcode.com/problems/count-and-say/

var countAndSay = function(n) {
    let current = "1";
    for (let k = 1; k < n; k++) {
        let result = "";
        let i = 0;
        while (i < current.length) {
            const ch = current[i];
            let j = i;
            while (j < current.length && current[j] === ch) {
                j++;
            }
            result += (j - i) + ch;
            i = j;
        }
        current = result;
    }
    return current;
};
