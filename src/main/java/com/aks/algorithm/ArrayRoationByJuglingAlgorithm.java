import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This Program to find rotate array elements using juggling algorithm Juggling
 * Algorithm: find GCD of length and d
 * 
 * @author PradeepKumar
 *
 */
public class ArrayRoationByJuglingAlgorithm {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = reader.readLine();
		String[] arr = line.trim().split("\\s+");
		int d = Integer.parseInt(reader.readLine());
		Integer a[] = new Integer[arr.length];
		Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList()).toArray(a);
		rotate(a, arr.length, d);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void rotate(Integer[] a, int length, int d) {

		int gcd = findGCD(length, d);
		int k = 0;
		for (int i = 0; i < gcd; i++) {
			int temp = a[i];
			int j = i;
			while (true) {
				/*
				 * Find K which element will be at a[j] position if after
				 * rotating d times in array
				 */
				k = (k + d) % length;
				/*
				 * When K position reach i means now j position should contain
				 * inistial element
				 */
				if (k == i)
					break;
				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
	}

	private static int findGCD(int first, int second) {
		if (second == 0)
			return first;

		return findGCD(second, first % second);
	}

}
