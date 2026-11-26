// https://leetcode.com/problems/largest-multiple-of-three/

var largestMultipleOfThree = function(digits) {
    digits.sort((a,b)=>a-b);
    let rem=digits.reduce((s,d)=>s+d,0)%3;
    if(rem){
        const idx1=digits.findIndex(d=>d%3===rem);
        if(idx1!==-1){digits.splice(idx1,1);}
        else{
            let cnt=0, i=0;
            while(i<digits.length&&cnt<2){
                if(digits[i]%3===(3-rem)){digits.splice(i,1);cnt++;}
                else i++;
            }
        }
    }
    if(!digits.length) return "";
    digits.sort((a,b)=>b-a);
    if(digits[0]===0) return "0";
    return digits.join('');
};
