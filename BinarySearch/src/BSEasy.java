/***
 * This class is for Binary Search easy questions.
 * Binary Search points
 *      - Arrays needs to be sorted.
 *      - Comparison starts with ***MID***
 */

public class BSEasy {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 3, 5, 6};
        System.out.println(searchInsertPostition_BruteForce(nums1, 5));
        System.out.println(searchInsertPostition_BruteForce(nums1, 2));
        System.out.println(searchInsertPostition_BruteForce(nums1, 7));

        System.out.println(searchInsertPostition(nums1, 5));
        System.out.println(searchInsertPostition(nums1, 2));
        System.out.println(searchInsertPostition(nums1, 7));

        int[] nums2 = new int[] {1};
        System.out.println(searchInsertPostition_BruteForce(nums2, 0));
        System.out.println(searchInsertPostition_BruteForce(nums2, 3));
        System.out.println(searchInsertPostition(nums2, 0));
        System.out.println(searchInsertPostition(nums2, 3));
    }

    //Brute Force - O(N)
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

    //Binary Search - O (Log N)
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

}
