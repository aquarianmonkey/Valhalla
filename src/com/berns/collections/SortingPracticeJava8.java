package com.berns.collections;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;

import com.berns.model.Egg;
import com.berns.model.Egg.Size;

public class SortingPracticeJava8 {

	static int[] quickSort1(int nums[]) {
		quickSort1(nums, 0, nums.length - 1);
		return nums;
	}

	private static void quickSort1(int nums[], int left, int right) {
		if (left < right) {
			int pi = partition(nums, left, right);
			quickSort1(nums, left, pi - 1);
			quickSort1(nums, pi + 1, right);
		}
	}

	private static int partition(int[] nums, int left, int right) {

		int i = -1;
		int pivotIdx = randomPivot(left, right);
		swap(nums, pivotIdx, right);   // set random pivot val to rightmost index

		int pivot = nums[right];
		for (int j = 0; j < right; j++) {

			if (nums[j] <= pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, right);

		return i + 1;
	}

	//median of 3
	private static int randomPivot(int left, int right) {
		Random random = new Random();
		int i1 = left + (random.nextInt(right - left + 1));
		int i2 = left + (random.nextInt(right - left + 1));
		int i3 = left + (random.nextInt(right - left + 1));

		return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int nums[] = { 10, 5, 6, 1, 7, 4, 9, 8, 2, 3 };

		System.out.println(Arrays.toString(quickSort1(nums)));

	}

	static void testComparatorWithSet() {

		Egg e1 = new Egg("soft", BigDecimal.valueOf(7.25));
		e1.setSize(Size.XLARGE);
		Egg e2 = new Egg("hard", BigDecimal.valueOf(6.25));
		e2.setSize(Size.MEDIUM);
		Egg e3 = new Egg("chewy", BigDecimal.valueOf(4.25));
		e3.setSize(Size.SMALL);
		Egg e4 = new Egg("awful", BigDecimal.valueOf(4.25));
		e4.setSize(Size.SMALL);

		Function<Egg, String> nameBased = Egg::getName;
		// SortedSet<Egg> ss = new TreeSet<Egg>((o1,o2)-> o1.name.compareTo(o2.name));
//		SortedSet<Egg> ss = new TreeSet<Egg>(Comparator.comparing(Egg::getName));
		// SortedSet<Egg> ss = new
		// TreeSet<Egg>(Comparator.comparing(Egg::getSize).thenComparing(nameBased));
		SortedSet<Egg> orderedEggs = new TreeSet<Egg>(Comparator.comparing(Egg::getPrice));
		orderedEggs.add(e2);
		orderedEggs.add(e1);
		orderedEggs.add(e3);
		orderedEggs.add(e4);

		System.out.println(orderedEggs);

	}

}
