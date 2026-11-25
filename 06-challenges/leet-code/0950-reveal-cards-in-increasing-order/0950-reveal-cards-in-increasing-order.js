// https://leetcode.com/problems/reveal-cards-in-increasing-order/

var deckRevealedIncreasing = function(deck) {
    deck.sort((a,b)=>a-b);
    const n = deck.length, result = new Array(n);
    const q = Array.from({length:n},(_,i)=>i);
    let qi = 0;
    for (const card of deck) {
        result[q[qi++]] = card;
        if (qi < n) q.push(q[qi++]);
    }
    return result;
};
