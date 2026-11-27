// https://leetcode.com/problems/unique-email-addresses/

var numUniqueEmails = function(emails) {
    const unique = new Set();
    for (const email of emails) {
        const [local, domain] = email.split('@');
        const normalized = local.split('+')[0].replace(/\./g, '') + '@' + domain;
        unique.add(normalized);
    }
    return unique.size;
};
