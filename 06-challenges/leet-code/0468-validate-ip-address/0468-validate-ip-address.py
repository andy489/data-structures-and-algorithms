# https://leetcode.com/problems/validate-ip-address/

class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        if '.' in queryIP:
            return "IPv4" if self._is_valid_ipv4(queryIP) else "Neither"
        elif ':' in queryIP:
            return "IPv6" if self._is_valid_ipv6(queryIP) else "Neither"
        return "Neither"

    def _is_valid_ipv4(self, ip: str) -> bool:
        parts = ip.split('.', -1)
        if len(parts) != 4:
            return False
        for part in parts:
            if not part or len(part) > 3:
                return False
            if len(part) > 1 and part[0] == '0':
                return False
            if not part.isdigit():
                return False
            if int(part) > 255:
                return False
        return True

    def _is_valid_ipv6(self, ip: str) -> bool:
        parts = ip.split(':', -1)
        if len(parts) != 8:
            return False
        hex_chars = set('0123456789abcdefABCDEF')
        for part in parts:
            if not part or len(part) > 4:
                return False
            if not all(c in hex_chars for c in part):
                return False
        return True
