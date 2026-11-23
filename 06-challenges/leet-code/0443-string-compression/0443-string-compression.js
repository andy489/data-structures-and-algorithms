// https://leetcode.com/problems/string-compression/

var compress = function(chars) {
    let read = 0, write = 0;
    while (read < chars.length) {
        const current = chars[read];
        let count = 0;
        while (read < chars.length && chars[read] === current) {
            read++;
            count++;
        }
        chars[write++] = current;
        if (count > 1) {
            for (const digit of String(count)) {
                chars[write++] = digit;
            }
        }
    }
    return write;
};
