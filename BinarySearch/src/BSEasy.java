/***
 * This class is for Binary Search easy questions.
 * Binary Search points
 *      - Arrays needs to be sorted.
 *      - Comparison starts with ***MID***
 */

public class BSEasy {

    public static void main(String[] args) {
        String divider = "*============================================*";

        int[] nums1 = new int[] {1, 3, 5, 6};
        System.out.println("Question 35 ans: " + searchInsertPostition_BruteForce(nums1, 5));
        System.out.println("Question 35 ans: " + searchInsertPostition_BruteForce(nums1, 2));
        System.out.println("Question 35 ans: " + searchInsertPostition_BruteForce(nums1, 7));

        System.out.println("Question 35 ans: " + searchInsertPostition(nums1, 5));
        System.out.println("Question 35 ans: " + searchInsertPostition(nums1, 2));
        System.out.println("Question 35 ans: " + searchInsertPostition(nums1, 7));

        int[] nums2 = new int[] {1};
        System.out.println("Question 35 ans: " + searchInsertPostition_BruteForce(nums2, 0));
        System.out.println("Question 35 ans: " + searchInsertPostition_BruteForce(nums2, 3));

        System.out.println("Question 35 ans: " + searchInsertPostition(nums2, 0));
        System.out.println("Question 35 ans: " + searchInsertPostition(nums2, 3));

        System.out.println(divider);
        System.out.println("Question 69 ans: " + sqrt2(69));
        System.out.println("Question 69 ans: " + sqrt2(8));
        System.out.println("Question 69 ans: " + sqrt2(123959393));
        System.out.println("Question 69 ans: " + sqrt2(1));
        System.out.println("Question 69 ans: " + sqrt2(0));
    }

    /**
     * #35
     * Brute Force - O(N)
     */
    public static int searchInsertPostition_BruteForce(int[] nums, int target) {
        for( int i = 0; i<nums.length; i++) {
            if( nums[i] == target) {
                return i;
            }
            else if( nums[i] > target ) {
                return i;
            }
            else if( i == nums.length-1 ) {
                return i+1;
            }
        }
        return -1;
    }

    /**
     * #35
     * Binary Search - O (Log N)
     */
    public static int searchInsertPostition(int[] nums, int target) {
        int high = nums.length;
        int low = 0;
        int mid = ( high - low ) / 2;

        while(high > low) {
            if( target == nums[mid] ) {
                return mid;
            }
            else if( target < nums[mid] ) {
                high = mid;
            }
            else if( target > nums[mid] ) {
                low = mid + 1;
            }
            //记住这个mid好吗 ：）
            mid = low + ( high - low ) / 2;
        }
        return low;
    }

    /**
     * #69
     */
    public static int sqrt(int x) {
        if( x < 2 ) {
            return x;
        }
        int high = x;
        int low = 0;
        // long type since mid*mid may overflow
        long mid = high / 2;

        while( high > low ) {
            long square = mid * mid;
            if( square == x) {
                return (int)mid;
            }
            else if( square < x) {
                low = (int)mid + 1;
            }
            else if( square > x) {
                high = (int)mid;
            }

            mid = low + ( high - low ) / 2;
        }

        return low - 1;
    }

    /**
     * #69 - enhanced
     * TODO: could it be even simplified???
     */
    public static int sqrt2(int x) {
        if( x < 2) {
            return x;
        }
        int high = x;
        int low = 0;
        int mid = x / 2;

        while( high >= low ) {
            if( x/mid == mid ) {
                return mid;
            }
            else if( x/mid < mid) {
                high = mid - 1;
            }
            else if( x/mid > mid ) {
                low = mid + 1;
            }

            mid = low + (high - low) / 2;
        }
        return high;
    }
}
