package BinarySearch;

import PrintUtility.PrintArrays;

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

        System.out.println(divider);
        System.out.println("Question 367 ans: " + isPerfectSquare(5));
        System.out.println("Question 367 ans: " + isPerfectSquare(14));
        System.out.println("Question 367 ans: " + isPerfectSquare(64));
        System.out.println("Question 367 ans: " + isPerfectSquare(4));
        System.out.println("Question 367 ans: " + isPerfectSquare(1));

        System.out.println(divider);
        System.out.println("Question 441 ans: " + arrangeCoins(1));
        System.out.println("Question 441 ans: " + arrangeCoins(2));
        System.out.println("Question 441 ans: " + arrangeCoins(3));
        System.out.println("Question 441 ans: " + arrangeCoins(8));
        System.out.println("Question 441 ans: " + arrangeCoins(2147483647));

        System.out.println(divider);
        int[] nums3 = new int[] {-1, 0, 3, 5, 9, 12};
        System.out.println("Question 704 ans: " + search(nums3, -1));
        System.out.println("Question 704 ans: " + search(nums3, 12));
        System.out.println("Question 704 ans: " + search(nums3, 9));
        System.out.println("Question 704 ans: " + search(nums3, 15));
        System.out.println("Question 704 ans: " + search(nums3, -5));

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
            // DIVISION AVOIDS OVERFLOW !!!
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

    /**
     * #367
     * NOTE : Pay attention to division... avoids overflow, but floor division result is dangerous for comparison.
     */
    public static boolean isPerfectSquare(int num) {
        if( num == 1 ) { return true; }
        int low = 0;
        int high = num/2;

        while( high >= low ) {
            int mid = low + (high-low)/2;
            double quotient = (double)num/(double)mid;
            if( quotient == mid ) {
                return true;
            }
            else if( quotient > mid ) {
                low = mid + 1;
            }
            else if( quotient < mid ) {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * 441
     */
    public static int arrangeCoins(int n) {
        int low = 0;
        int high = n;

        while(high >= low) {
            long mid = low + (high-low)/2;
            long sum = ( mid*(mid+1) )/2;
            if( sum == n ) {
                return (int) mid;
            }
            else if( sum > n ) {
                high = (int)mid-1;
            }
            else if( sum < n ) {
                low = (int)mid+1;
            }
        }
        return high;
    }

    /**
     * #704 - 一次过！干得漂亮！
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(high >= low) {
            int mid = low + (high-low)/2;
            if( nums[mid] == target ) {
                return mid;
            }
            else if( nums[mid] < target ) {
                low = mid + 1;
            }
            else if( nums[mid] > target ) {
                high = mid - 1;
            }
        }
        return -1;
    }

}
