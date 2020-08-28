package BinarySearch;

import PrintUtility.PrintArrays;

/***
 * This class is for Binary Search medium questions.
 * Binary Search points
 *      - Arrays needs to be sorted.
 *      - Comparison starts with ***MID***
 */

public class BSMedium {

    public static void main(String[] args) {
        String divider = "*============================================*";

        int[] nums1 = new int[] {5,7,7,8,8,8,10};
        int[] nums2 = new int[] {5,7,8,8,10};
        System.out.print("Question 34 ans: " );
        PrintArrays.printArray(SearchRangeBS(nums1, 8));
        System.out.print("Question 34 ans: " );
        PrintArrays.printArray(SearchRangeBS(nums2, 7));
        System.out.print("Question 34 ans: " );
        PrintArrays.printArray(SearchRangeBS(nums2, 8));
        System.out.print("Question 34 ans: " );
        PrintArrays.printArray(SearchRangeBS(new int[] {}, 8));
        System.out.print("Question 34 ans: " );
        PrintArrays.printArray(SearchRangeBS(new int[] {1}, 1));
    }

    /**
     * #34 - Brute Force
     */
    public static int[] SearchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        for(int i = 0; i<nums.length; i++) {
            if( nums[i] == target ) {
                result[0] = i;
                break;
            }
        }
        if( result[0] == -1 ) { return result; }

        for(int i = nums.length-1; i>0; i--) {
            if(nums[i] == target ) {
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    /**
     * #34
     */
    public static int[] SearchRangeBS(int[] nums, int target) {
        if( nums.length == 0 ) { return new int[] {-1, -1}; }
        int low = 0;
        int high = nums.length;

        while(high > low) {
            int mid = low + (high-low)/2;
            if( nums[mid] >= target ) {
                high = mid;
            }
            else if( nums[mid] < target ) {
                low = mid+1;
            }
        }

        if( low >= nums.length || nums[low] != target ) {
            return new int[] {-1, -1};
        }

        int right = searchRight(nums, target, low);
        return new int[]{low, right};
    }

    private static int searchRight(int[] nums, int target, int start) {
        int low = start;
        int high = nums.length;

        while(high > low) {
            int mid = low + (high-low)/2;
            if( nums[mid] <= target ) {
                low = mid+1;
            }
            else if( nums[mid] > target ) {
                high = mid-1;
            }
        }
        if( high == nums.length || nums[high] != target ) {
            return high-1;
        }
        return high;
    }

}
