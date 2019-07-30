

package sort.radix;

public class RadixString {

	// Radix algorithm
	// Makes assumptions that data has same radix (radix for decimal system is 10 , radix for alphabet is 26, binary 2) and width
	// Sorted from the right most position like the unit, then 10th , then 100th
	// Sorted on each individual letter or digit and data can be integers or strings

	private static String [] radixArray = {"hgfdh", "cvzas", "wedas", "lkmng", "aaaaa"};

	public static void main(String[] args) {

		radix(radixArray, 26, 5);

		for(String mev: radixArray) {
			System.out.println(mev);
		}

	}


	private static void radix(String [] myArray, int radix, int width) {

		for(int i = width -1 ; i >= 0; i --) {
			radixSingleSort(myArray,radix, i);
		}
	}


	private static int getIndex(String myValue, int position) {
		return myValue.charAt(position) - 'a';
	}

	private static void radixSingleSort(String[] myArray, int radix, int position) {
		int numItems = myArray.length;

		int [] countArray = new int [radix];


		for(String myValue : myArray) {
			countArray[getIndex(myValue, position)]++;
		}

		// Adjust the count array
		for(int j = 1; j < radix; j++) {
			countArray[j] += countArray[j-1];
		}

		String [] tempArray = new String [numItems];

		for(int tempIndex = numItems - 1; tempIndex >= 0 ; tempIndex--) {

			tempArray[--countArray[getIndex(myArray[tempIndex], position)]] = myArray[tempIndex];
		}


		System.arraycopy(tempArray, 0, myArray, 0 , tempArray.length);


	}
}