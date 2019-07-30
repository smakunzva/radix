

package sort.radix;

public class Radix {

	// Radix algorithm
	// Makes assumptions that data has same radix (radix for decimal system is 10 , radix for alphabet is 26, binary 2) and width
	// Sorted from the right most position like the unit, then 10th , then 100th
	// Sorted on each individual letter or digit and data can be integers or strings

	private static int [] radixArray = {1232, 3343, 2323, 2345,9087, 7636};

	public static void main(String[] args) {

		radix(radixArray, 10, 4);

		for(int mev: radixArray) {
			System.out.println(mev);
		}

	}


	private static void radix(int [] myArray, int radix, int width) {

		for(int i = 0 ; i < width; i++) {
			radixSingleSort(radixArray, radix, i);
		}
	}


	private static int getDigit(int myValue, int position, int radix) {
		//System.out.println("i : " + position);
		return ((myValue / (int)Math.pow(10, position)) % radix);
	}

	private static void radixSingleSort(int[] myArray, int radix, int position) {
		int numItems = myArray.length;

		int [] countArray = new int [radix];


		for(int myValue : myArray) {
			countArray[getDigit(myValue, position, radix)]++;
		}

		// Adjust the count array
		for(int j = 1; j < radix; j++) {
			countArray[j] += countArray[j-1];
		}

		int [] tempArray = new int [numItems];

		for(int tempIndex = numItems - 1; tempIndex >= 0 ; tempIndex--) {

			tempArray[--countArray[getDigit(myArray[tempIndex], position, radix)]] = myArray[tempIndex];
		}


		System.arraycopy(tempArray, 0, myArray, 0 , tempArray.length);


	}
}