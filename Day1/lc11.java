//https://leetcode.com/problems/container-with-most-water/description/

// maximum amount of water in a container can be equal to the area of rectanle.

// to calculate area we have to take lower side of height.

// Brute force approach:-
// take two var, one for area and another for current area.
// by using two for loops, we can find max area

// for optimal solution we will take 2 pointers at the start and end. these pointers will move towards each other.

// then we will calculate the width using r-l and will take minimum height out of l and r.

// then we will store the area in variable MaxArea.

// Then we will move the pointer with smaller height.

class Solution {
    public int maxArea(int[] height) {
        

        // variables
        int max = 0;
        int left = 0;
        int right = height.length-1;

        // loop till left and right pointers cross each other.
        while(left<right){
            

            // find width to calculate area
            int width = right-left;


            // find area w * minimum_height
            int area = Math.min(height[left],height[right])*width;

            // store the maximum area in max variable
            max = Math.max(area,max);


            // shift the pointers accordingly
            
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }


        }
        return max;


    }
}
