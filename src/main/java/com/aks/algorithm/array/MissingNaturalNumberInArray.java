
/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

class MissingNaturalNumberInArray {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(reader.readLine());
		while (t > 0) {
			int size = Integer.valueOf(reader.readLine());
			String[] s = reader.readLine().split("\\s+");
			Integer arr[] = new Integer[s.length];
			Arrays.stream(s).map(Integer::valueOf).collect(Collectors.toList()).toArray(arr);
			System.out.println(missing(arr, size));
			t--;
		}
	}

	public static int missing(Integer[] arr, int size) {
		int sum = 0;
		for (int i = 0; i < size - 1; i++) {
			sum += arr[i];
		}

		return ((size * (size + 1)) / 2) - sum;
	}
}