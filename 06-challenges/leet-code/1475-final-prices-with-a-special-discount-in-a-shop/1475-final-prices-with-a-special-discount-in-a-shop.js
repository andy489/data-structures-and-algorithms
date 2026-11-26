// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

var finalPrices = function(prices) {
    const res=[...prices], stack=[];
    for(let i=0;i<prices.length;i++){
        while(stack.length&&prices[stack[stack.length-1]]>=prices[i])
            res[stack.pop()]-=prices[i];
        stack.push(i);
    }
    return res;
};
