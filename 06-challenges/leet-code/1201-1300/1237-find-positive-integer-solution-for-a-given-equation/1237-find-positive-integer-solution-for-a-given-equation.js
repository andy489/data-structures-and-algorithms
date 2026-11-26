// https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

var findSolution = function(customfunction, z) {
    const res=[]; let x=1,y=1000;
    while(x<=1000&&y>=1){
        const v=customfunction.f(x,y);
        if(v===z){res.push([x++,y--]);}
        else if(v<z){x++;}
        else{y--;}
    }
    return res;
};
