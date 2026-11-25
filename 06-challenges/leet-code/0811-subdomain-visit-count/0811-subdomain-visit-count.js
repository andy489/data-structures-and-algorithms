// https://leetcode.com/problems/subdomain-visit-count/

var subdomainVisits = function(cpdomains) {
    const counts = new Map();
    for (const entry of cpdomains) {
        const [countStr, domain] = entry.split(' ');
        const count = parseInt(countStr);
        const parts = domain.split('.');
        for (let i = 0; i < parts.length; i++) {
            const sub = parts.slice(i).join('.');
            counts.set(sub, (counts.get(sub) || 0) + count);
        }
    }
    return [...counts.entries()].map(([k, v]) => `${v} ${k}`);
};
