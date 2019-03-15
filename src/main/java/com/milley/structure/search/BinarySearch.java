package com.milley.structure.search;

public class BinarySearch {
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bsearchWithRecursion(int[] a, int n, int value) {
        return bsearchInternally(a, 0, n - 1, value);
    }

    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    public static int binarySearchFirstElement(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearchLastElement(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearchFirstGreaterThanElement(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLastLessThanElement(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int binarySearchLoopInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) return mid;
        if (a[low] < a[mid]) {
            // 前半部分有序，后半部分循环有序数组
            if (a[mid] > value) {
                if (a[low] <= value) {
                    return bsearchInternally(a, low, mid - 1, value);
                } else {
                    return binarySearchLoopInternally(a, mid + 1, high, value);
                }
            } else if (a[mid] < value){
                return binarySearchLoopInternally(a, mid + 1, high, value);
            } else {
                return mid;
            }
        } else if (a[low] > a[mid]){
            // 后半部分有序，前半部分循环有序数组
            if (a[mid] < value) {
                if (a[high] >= value) {
                    return bsearchInternally(a, mid + 1, high, value);
                } else {
                    return binarySearchLoopInternally(a, low, mid - 1, value);
                }
            } else if (a[mid] > value){
                return binarySearchLoopInternally(a, low, mid - 1, value);
            } else {
                return mid;
            }
        } else {
            if (a[low] == value) return low;
            if (a[high] == value) return high;
            return -1;
        }
    }

    // 循环数组二分查找
    public static int binarySearchLoopArray(int[] a, int n, int value) {
        if (n == 1 && a[0] == value) return 0;
        if (n == 1 && a[0] != value) return -1;
        return binarySearchLoopInternally(a, 0, n - 1, value);
    }
}
