package Arrays;

public class Checker {

	public static void main(String args[]) {

		System.out.println(updateNumber(9, 2));
	}

	public static int updateNumber(int number, int power) {

		int num = number;
		int count = 0;

		while (count < power) {
			num = num * 10;
			count++;
		}

		int sum = 1;
		int pow = power;
		count=0;
		while (count < pow) {
			sum = sum * 10;
			count++;
		}
		sum = sum - 1;
		return num + sum;
	}
}
