

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        left, right = 0, 0
        chars = []
        print self
        for index in range(len(s)):
            char = s[index]
            if char in chars:
                print "in"

            else:
                print "not in"
                chars.append(char)


if __name__ == "__main__":
    solution = Solution()
    solution.lengthOfLongestSubstring("123123")





