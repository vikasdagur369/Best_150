//https://leetcode.com/problems/permutation-in-string/description/

// using brute force we can solve this problem, we can make all substrings of s1 and check in s2.

// to solve this problem we have to store the frequency of every character of S1.

// we can use hashMap or array with character 26.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Clearing possible edge case where length of s1 exceeds s2
        if(s1.length() > s2.length()) return false;

    // creating arrays for storing frequency of characters
        int [] s1count = new int[26];
        int [] s2count = new int[26];
    // storing frequency of characters for string s1
        for(char s : s1.toCharArray()){
            s1count[s-'a']++;
        }

    //Initializing sliding window
        int left=0, right=0;
        int s2len = s2.length();
        while(right<s2len){
        // Saving the frequency of character at right pointer
            s2count[s2.charAt(right)-'a']++;

        //if length of window exceeds s1, we need to shrink it. Removing 1st character and sliding the left pointer forward
            if(right-left+1 > s1.length()){
                s2count[s2.charAt(left)-'a']--;
                left++;
            }
        //Comparing both arrays
            if(Arrays.equals(s1count,s2count)){
                return true;
            }
            right++;
        }
        return false;

    }
}