// https://leetcode.com/problems/magical-string/

var magicalString = function(n) {
    if (n <= 3) return 1;
    const magic = [1, 2, 2];
    let head = 2;
    let nextDigit = 1;
    let onesCount = 1;

    while (magic.length < n) {
        const copies = magic[head];
        for (let i = 0; i < copies && magic.length < n; i++) {
            magic.push(nextDigit);
            if (nextDigit === 1) onesCount++;
        }
        nextDigit = 3 - nextDigit;
        head++;
    }
    return onesCount;
};
