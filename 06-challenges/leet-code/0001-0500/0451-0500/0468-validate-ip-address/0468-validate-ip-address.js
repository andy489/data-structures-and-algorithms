// https://leetcode.com/problems/validate-ip-address/

var validIPAddress = function(queryIP) {
    if (queryIP.includes('.')) {
        return isValidIPv4(queryIP) ? "IPv4" : "Neither";
    } else if (queryIP.includes(':')) {
        return isValidIPv6(queryIP) ? "IPv6" : "Neither";
    }
    return "Neither";
};

function isValidIPv4(ip) {
    const parts = ip.split('.');
    if (parts.length !== 4) {
        return false;
    }
    for (const part of parts) {
        if (!part || part.length > 3) {
            return false;
        }
        if (part.length > 1 && part[0] === '0') {
            return false;
        }
        if (!/^\d+$/.test(part)) {
            return false;
        }
        if (parseInt(part) > 255) {
            return false;
        }
    }
    return true;
}

function isValidIPv6(ip) {
    const parts = ip.split(':');
    if (parts.length !== 8) {
        return false;
    }
    const hexPattern = /^[0-9a-fA-F]{1,4}$/;
    for (const part of parts) {
        if (!hexPattern.test(part)) {
            return false;
        }
    }
    return true;
}
