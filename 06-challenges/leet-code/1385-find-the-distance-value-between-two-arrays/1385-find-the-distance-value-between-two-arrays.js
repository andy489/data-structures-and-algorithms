// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

var findTheDistanceValue = function(arr1, arr2, d) {
    arr2.sort((a,b)=>a-b);
    const bs=(arr,t,left)=>{let lo=0,hi=arr.length;while(lo<hi){const m=(lo+hi)>>1;arr[m]<t||(left&&arr[m]===t)?hi=m:lo=m+1;}return lo;};
    return arr1.filter(v=>{
        const lo=arr2.findIndex(x=>x>=v-d);
        const hi=arr2.findLastIndex(x=>x<=v+d);
        return lo===-1||hi===-1||lo>hi;
    }).length;
};
