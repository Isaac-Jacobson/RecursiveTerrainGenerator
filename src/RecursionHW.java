
public class RecursionHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*Problem 1 output:
	 * 2 4 8 16 32 32 16 24 24 8 12 24 24 12 4 6 12 24 24 12 18 18 6 2
	 */
	
	public static boolean groupSum(int start, int[] arr, int target) {
		if (target == 0) {
			return true;
		}
		if (target < 0 || start >= arr.length) {
			return false;
		}
		if (groupSum(start + 1, arr, target - start)) {
			return true;
		}
		if (groupSum(start + 1, arr, target)) {
			return true;
		}
		return false;
	}

}
