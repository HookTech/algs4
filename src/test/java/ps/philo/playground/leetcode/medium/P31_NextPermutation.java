package ps.philo.playground.leetcode.medium;

import edu.princeton.cs.test.TestUtil;
import org.testng.annotations.Test;

/**
 * philo
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * # 3/23/19
 */
public class P31_NextPermutation {

	@Test
	public void test() {
		int[] nums = new int[]{1, 3, 2};
		nextPermutation(nums);
		TestUtil.assertEqualArray(nums, new int[]{2, 1, 3});
	}

	public void nextPermutation(int[] nums) {
		if (nums.length < 2) return;
		int i = nums.length - 2;
		while (nums[i + 1] <= nums[i]) {
			i--;
			if (i < 0) {
				swapRange(nums, 0, nums.length - 1);
				return;
			}
		}
		int j = nums.length - 1;
		while (nums[j] <= nums[i]) {
			j--;
		}
		swap(nums, i++, j);
		swapRange(nums, i, nums.length - 1);
	}

	public void swapRange(int[] nums, int lo, int hi) {
		int mid = (lo + hi) / 2;
		int i = lo, j = hi;
		while (i <= mid) {
			swap(nums, i++, j--);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
