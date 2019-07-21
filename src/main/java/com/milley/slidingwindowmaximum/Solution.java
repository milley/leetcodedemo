package com.milley.slidingwindowmaximum;

import java.util.*;

/**
 * @author milley
 */
public class Solution {
    private PriorityQueue<Integer> queue;

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();

        if (nums.length == 0) {
            return new int[]{};
        }

        queue = new PriorityQueue<>(k, (lhs, rhs) -> rhs - lhs);

        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
            }
            arr.add(queue.peek());
        } else {
            for (int i = 0; i <= nums.length - k; i++) {
                queue.clear();
                for (int j = 0; j < k; j++) {
                    queue.add(nums[i + j]);
                }
                arr.add(queue.peek());
            }
        }


        return arr.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] maxSlidingWindowByQueue(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }

        Deque<Integer> window = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; ++i) {
            if (i >= k && window.getFirst() <= i - k) {
                window.pop();
            }

            Iterator<Integer> iter = window.iterator();
            while (!window.isEmpty() && iter.next() <= nums[i]) {
                iter.remove();
            }
            window.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[window.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        //int[] arr = new int[]{};
        //int[] res = new Solution().maxSlidingWindow(arr, 3);
        int[] res = new Solution().maxSlidingWindowByQueue(arr, 3);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
