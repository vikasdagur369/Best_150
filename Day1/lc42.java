// https://leetcode.com/problems/trapping-rain-water/description/

// we have to calculate the total unit of water that will be stored by an array.

// water trapped will be equal to diffrence of bar height i.e larger height minus minimum height.

// Min(Rh,Lh)-H > -> this formulae will solve this problem and will tell the amount of water.

// so we have to find Rh and Lh correctly, then it will be very easy problem to solve.

// Brute force :-

// iterate over the array two times.

// So the crux of the problem is in formulae.

// Better approach can be using two new arrays that will store Lmax and Rmax.
// iterating from left to right , we can fill Lmax array, and in reverse order we can fill the Rmax.

// it is good approach but not optimal.

// we can solve this problem using two pointers approach optimally.


class Solution {
    public int trap(int[] height) {
        int left = 0; // Starting from left end
        int right = height.length - 1; // Starting from right end

        int total = 0; // To accumulate trapped water
        int leftMax = height[0]; // Initial left boundary
        int rightMax = height[right]; // Initial right boundary

        while (left < right) {
            if (height[left] < height[right]) {
                
                leftMax = Math.max(leftMax, height[left]); // Update left boundary
                
                total += leftMax - height[left]; // Calculate trapped water
                
                left++; // Move left pointer
            } 
            
            else {
                
                rightMax = Math.max(rightMax, height[right]); // Update right boundary
                
                total += rightMax - height[right]; // Calculate trapped water
                
                right--; // Move right pointer
            }
        }
        return total; // Return the total trapped water
    }
}

