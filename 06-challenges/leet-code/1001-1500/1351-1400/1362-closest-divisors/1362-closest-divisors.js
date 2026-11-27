// https://leetcode.com/problems/closest-divisors/

var closestDivisors = function(num) {
    let best=[1,num+2];
    for(const target of [num+1,num+2]){
        for(let a=Math.floor(Math.sqrt(target));a>=1;a--){
            if(target%a===0){
                const b=target/a;
                if(b-a<best[1]-best[0]) best=[a,b];
                break;
            }
        }
    }
    return best;
};
