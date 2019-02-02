package com.milley.structure.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private int depth = 0;
    private Map<Integer, Integer> cacheMapping;

    public Fibonacci() {
        cacheMapping = new HashMap<>();
    }

    public int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2);
    }

    public int fWithDepth(int n) throws Exception {
        ++depth;
        if (depth > 1000) {
            throw new Exception("depth > 1000");
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fWithDepth(n - 1) + f(n - 2);
    }

    public int fWithCache(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (cacheMapping.containsKey(n)) {
            return cacheMapping.get(n);
        }

        int ret = fWithCache(n - 1) + fWithCache(n - 2);
        cacheMapping.put(n, ret);
        return ret;
    }

    public int fWithLoop(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
}
