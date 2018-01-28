package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GFG {
	public static void main(String[] args) {
		// code

	//	Scanner sc = new Scanner(System.in);
	//	int testCase = sc.nextInt();
	//	sc.nextLine();
	//	for (int i = 0; i < testCase; i++) {

		
		int[] array={598, 649, 705, 551, 151, 977, 413, 555, 798, 505, 382, 749, 66, 379, 700, 210, 130,
				    554, 484, 448, 608, 774, 323, 306, 177, 54 ,225, 631 ,367 ,401 ,445, 371, 286 ,17,
				    899, 156, 134, 558, 577, 179, 267, 358, 712, 879, 615, 820, 738, 134, 592, 721, 763, 634, 198, 32, 589,
				    590, 874, 878, 305, 359, 201, 255, 961, 916, 948};
			int size = array.length;
		//	sc.nextLine();
			int max = 0;
			for (int j = 0; j < size; j++) {


				if (max < array[j]) {
					max = array[j];
				}
			}
		//	}

			float[] newArray = new float[size];
			Map<Float, Integer> map = new HashMap<Float, Integer>();

			int maxCount = getDigitsCount(max);
			for (int j = 0; j < size; j++) {

				int digCount = getDigitsCount(array[j]);

				if (digCount < maxCount) {
					int modifiedNumber = updateNumber(array[j], maxCount);
					newArray[j] = modifiedNumber;
				} else {
					newArray[j] = array[j];
				}
				if (map.containsKey(newArray[j])) {

					int count = map.get(newArray[j]);
					if (count > digCount) {
						map.put(newArray[j] + 0.1f, digCount);
						newArray[j] = newArray[j] + 0.1f;

					} else {

						map.put(newArray[j], digCount);
						map.put(newArray[j] + 0.1f, count);
						newArray[j] = newArray[j] + 0.1f;
					}

				} else {
					map.put(newArray[j], digCount);
				}

			}

			Arrays.sort(newArray);

			StringBuilder sb = new StringBuilder();
			for (int j = size - 1; j >= 0; j--) {

				float number = newArray[j];
				String num = "" + Math.round(number);
				int count = map.get(number);
				num = num.substring(0, count);
				sb.append(num);

			}

			System.out.println(sb.toString());
		

	}

	public static int getDigitsCount(int number) {

		int count = 0;
		int checker = number;
		while (checker > 0) {
			checker = checker / 10;
			count++;
		}

		return count;
	}

	public static int updateNumber(int number, int power) {

		int num = number;

		int counter=0;
		String newNumber=""+num;
		while(counter<power){
			newNumber=newNumber+num;
			counter++;
		}

		newNumber=newNumber.substring(0,power);

		
		return Integer.parseInt(newNumber);
	}
}