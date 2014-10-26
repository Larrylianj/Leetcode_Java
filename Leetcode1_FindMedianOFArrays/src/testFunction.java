import java.lang.reflect.Array;
import java.util.Arrays;


public class testFunction extends FindMedianOfArrays {

	private static FindMedianOfArrays test;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test = new FindMedianOfArrays();
		
		int A[] = {1,3,5,7,9,11,23,34};
		int B[] = {1,2,6,8,10};
		double c = test.findMedianSortedArrays(A, B);
		System.out.println(c);
		
	}

}
