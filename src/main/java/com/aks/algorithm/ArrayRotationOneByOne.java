import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayRotation {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] arr = line.trim().split("\\s+");
			Integer[] a = new Integer[arr.length];
			Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList()).toArray(a);
			rotateArray(a, a.length, 2);
			for(int i:a){
				System.out.print(i+" ");
			}
		}
		reader.close();

	}

	public static void rotateArray(Integer[] arr, int n, int d) {
		for (int i = 0; i <= d - 1; i++)
			rotate(arr, n);
	}

	private static void rotate(Integer[] arr, int n) {
		int temp = arr[0];
		int i = 0;
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];

		arr[i] = temp;

	}

}
