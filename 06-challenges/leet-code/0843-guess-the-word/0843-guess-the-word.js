// https://leetcode.com/problems/guess-the-word/

var findSecretWord = function(words, master) {
    function match(a, b) {
        let count = 0;
        for (let i = 0; i < a.length; i++) {
            if (a[i] === b[i]) count++;
        }
        return count;
    }
    let candidates = words.slice();
    for (let i = 0; i < 10 && candidates.length > 0; i++) {
        const guess = candidates[Math.floor(Math.random() * candidates.length)];
        const m = master.guess(guess);
        candidates = candidates.filter(w => w !== guess && match(guess, w) === m);
    }
};
