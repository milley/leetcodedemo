package com.milley.structure.guava.joiner;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class JoinerTest {
    private static final Joiner joiner = Joiner.on(",").skipNulls();
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    public static void main(String[] args) {
        String join = joiner.join(Lists.newArrayList("A", null, "b", " ", "c"));
        System.out.println("join=" + join);

        for (String tmp : splitter.split(" a,    ,b,    , c  ")) {
            System.out.println("{" + tmp + "}");
        }
    }
}
