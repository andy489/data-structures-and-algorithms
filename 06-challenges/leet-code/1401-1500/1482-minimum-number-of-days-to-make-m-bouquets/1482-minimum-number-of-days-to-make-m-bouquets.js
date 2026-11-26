// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

var minDays = function(bloomDay, m, k) {
    if (m*k > bloomDay.length) return -1;
    const canMake = day => {
        let b=0,c=0;
        for (const d of bloomDay) { if(d<=day){c++;if(c===k){b++;c=0;}}else c=0; }
        return b >= m;
    };
    let lo=1, hi=Math.max(...bloomDay);
    while(lo<hi){const mid=(lo+hi)>>1;canMake(mid)?hi=mid:lo=mid+1;}
    return lo;
};
