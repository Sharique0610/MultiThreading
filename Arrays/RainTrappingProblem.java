package Arrays;

public class RainTrappingProblem {

	public static void main(String args[]) {

		int[] array = { 2, 0, 0, 0, 3, 0, 1, 0, 0, 4, 0, 1 };
		int[] array1={3,0,0,2,0,4};
		int[] array2={0,1,0,2,1,0,1,3,2,2,1};

		System.out.println(calculateArea(array2));

	}

	public static int calculateArea(int[] array) {

		int left = array[0];
		int right = 0;
		int sum = 0;
		int counter = 0;
		for (int i = 1; i < array.length; i++) {

			if (array[i] == 0) {

				counter++;
			} else {
				right = array[i];
				if (right > left) {
					sum = sum + (left * counter);
					left = right;

				} else {

					sum = sum + (right * counter);

				}
				counter = 0;
			}

		}

		return sum;

	}
}
