package PrintUtility;
/***
 * This class is for help print Array and Arraylists.
 */
public class PrintArrays {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        printArray(arr);
    }

    public static void printArray( int[] arr ) {
        String result = "[ ";
        for( int i = 0; i<arr.length; i++ ) {
            result += arr[i];
            if( i != arr.length-1 ) {
                result += ',';
            }
        }
        result += " ] ";
        System.out.println(result);
    }

}
