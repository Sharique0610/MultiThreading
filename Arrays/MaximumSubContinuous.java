package Arrays;

public class MaximumSubContinuous {

	public static void main(String args[]) {

		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	public static int maxSubArraySum(int[] array) {
		int max_value = Integer.MIN_VALUE;
		int max_so_far = 0;

		for (int i = 0; i < array.length; i++) {

			max_so_far = max_so_far + array[i];

			if (max_value < max_so_far) {

				max_value = max_so_far;
			}

			if (max_so_far < 0) {

				max_so_far = 0;
			}

		}

		return max_value;
	}
}
