//https://leetcode.com/problems/longest-repeating-character-replacement/description/

// brute force:

// we take every substring possible and then replace any k characters then return highest length.

// intution can be that we count the occurence of every character in a string.

// we can solve the problem using sliding window approach.

// so we can identify that , longest substring will contain the character with highest frequency, because that character can become larger in number using the addition of k.

class Solution {
    public int characterReplacement(String s, int k) {
        
        // Create an array to keep track of the frequency of each character in the window
        int [] freq = new int[26];
        
        // Initialize the pointers for the sliding window
        int left = 0;
        int right = 0;
        
        // maxFreq keeps track of the highest frequency of a single character in the current window
        int maxFreq = 0;
        
        // maxWindow stores the size of the largest window found
        int maxWindow = 0;

        // Iterate through the string with the right pointer
        for(right = 0; right < s.length(); right++) {
            
            // Update the frequency of the current character in the window
            freq[s.charAt(right) - 'A']++;

            // Update the max frequency of any single character in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Calculate the length of the current window
            int windowLength = right - left + 1;

            // If the difference between the window length and the max frequency is greater than k,
            // it means we need to shrink the window from the left side
            if (windowLength - maxFreq > k) {
                // Decrement the frequency of the character that will be removed from the window
                freq[s.charAt(left) - 'A']--;
                
                // Move the left pointer to the right, shrinking the window
                left++;
            }

            // Recalculate the length of the current window after potentially shrinking it
            windowLength = right - left + 1;

            // Update the maximum window size if the current window is larger
            maxWindow = Math.max(maxWindow, windowLength);
        }

        // Return the size of the largest window found
        return maxWindow;
    }
}

