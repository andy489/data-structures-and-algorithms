// https://leetcode.com/problems/bag-of-tokens/

var bagOfTokensScore = function(tokens, power) {
    tokens.sort((a,b)=>a-b);
    let lo=0, hi=tokens.length-1, score=0, maxScore=0;
    while (lo<=hi) {
        if (power>=tokens[lo]) { power-=tokens[lo++]; maxScore=Math.max(maxScore,++score); }
        else if (score>0) { power+=tokens[hi--]; score--; }
        else break;
    }
    return maxScore;
};
