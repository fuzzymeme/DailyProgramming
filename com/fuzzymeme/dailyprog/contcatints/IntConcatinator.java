package com.fuzzymeme.dailyprog.contcatints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class IntConcatinator {	
	
	public long getLowest(final int ... arrayOfInts) {
		return getBest(arrayOfInts, (x, y) -> x < y);
	}

	public long getHighest(final int ... arrayOfInts) {
		return getBest(arrayOfInts, (x, y) -> x > y);
	}

	public long getBest(final int[] inputArray, final BiPredicate<Long, Long> binaryTest) {
		
		List<Integer> bestList = new ArrayList<>();
		for(int numlength = 20; numlength >= 1; numlength--) {  // Magic number 20, if we have very long numbers in the input than it doesn't work - but only takes ints anyway
			List<Integer> numsOfLen = getInputsOfLength(numlength, inputArray);		

			for(int numToInsert: numsOfLen) {
				bestList = findBestPositionForGivenInt(numToInsert, bestList, binaryTest);
			}
		}
		
		return makeNumberFromList(bestList);		
	}
	
	private List<Integer> findBestPositionForGivenInt(final int newVal, final List<Integer> intList, final BiPredicate<Long, Long> binaryTest) {
				
		long bestValue = 0;
		List<Integer> bestSubList = new ArrayList<>();
		for(int i = 0; i <= intList.size(); i++) {
			List<Integer> candidateList = new ArrayList<>(intList); // make candidateList with inputList
			candidateList.add(i, newVal);
			long value = makeNumberFromList(candidateList);
			if(i == 0 || binaryTest.test(value, bestValue)) {
				bestValue = value;
				bestSubList = candidateList;
			}
		}
		
		return bestSubList;
	}
		
	private List<Integer> getInputsOfLength(final int len, final int[] inputArray) {		
		return Arrays.stream(inputArray).filter(i -> ("" + i).length() == len ).boxed().collect(Collectors.toList());
	}
	
	private long makeNumberFromList(List<Integer> listOfInts) {		
		return Long.parseLong(listOfInts.stream()
		        .map(number -> "" + number)
		        .collect(Collectors.joining("")));
	}
	
	
	public static void main(String[] args) {
		
		int[] inputArray = new int[]{5, 56, 50};
		
		IntConcatinator catty = new IntConcatinator();
		
		long lowest = catty.getLowest(inputArray);
		System.out.println("least: " + lowest);

		long highest = catty.getHighest(inputArray);
		System.out.println("highest: " + highest);		

	}

}
