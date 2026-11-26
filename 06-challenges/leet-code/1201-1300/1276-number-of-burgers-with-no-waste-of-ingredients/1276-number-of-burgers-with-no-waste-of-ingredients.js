// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

var numOfBurgers = function(tomatoSlices, cheeseSlices) {
    const diff=tomatoSlices-2*cheeseSlices;
    if(diff<0||diff%2!==0)return[];
    const jumbo=diff>>1,small=cheeseSlices-jumbo;
    return small>=0?[jumbo,small]:[];
};
