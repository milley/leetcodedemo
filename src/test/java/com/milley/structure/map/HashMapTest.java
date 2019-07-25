package com.milley.structure.map;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HashMapTest {
    public class Person {
        private String name;
        private int age;
        private String email;

        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public class PersonImplEquals extends Object {
        private String name;
        private int age;
        private String email;

        public PersonImplEquals(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonImplEquals that = (PersonImplEquals) o;
            return age == that.age &&
                    name.equals(that.name) &&
                    email.equals(that.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, email);
        }
    }

    @Test
    public void whenCompareTwoHashMapsUsingEquals_thenSuccess() {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        sMap.put('a', 1);
        sMap.put('b', 0);
        sMap.put('c', 3);

        tMap.put('c', 3);
        tMap.put('a', 1);
        tMap.put('b', 0);

        assertTrue(sMap.equals(tMap));
        assertFalse(sMap == tMap);
    }

    @Test
    public void whenCompareTwoHashMapUsingEquals_withNoEquals_thenSuccess() {
        Map<String, Person> sMap = new HashMap<>();
        Map<String, Person> tMap = new HashMap<>();

        sMap.put("zhangsan", new Person("zhangsan", 18, "zhangsan@123.com"));
        sMap.put("lisi", new Person("lisi", 20, "lisi@123.com"));

        tMap.put("lisi", new Person("lisi", 20, "lisi@123.com"));
        tMap.put("zhangsan", new Person("zhangsan", 18, "zhangsan@123.com"));

        assertFalse(sMap.equals(tMap));
    }

    @Test
    public void whenCompareTwoHashMapUsingEquals_withEquals_thenSuccess() {
        Map<String, PersonImplEquals> sMap = new HashMap<>();
        Map<String, PersonImplEquals> tMap = new HashMap<>();

        sMap.put("zhangsan", new PersonImplEquals("zhangsan", 18, "zhangsan@123.com"));
        sMap.put("lisi", new PersonImplEquals("lisi", 20, "lisi@123.com"));

        tMap.put("lisi", new PersonImplEquals("lisi", 20, "lisi@123.com"));
        tMap.put("zhangsan", new PersonImplEquals("zhangsan", 18, "zhangsan@123.com"));

        assertTrue(sMap.equals(tMap));
    }

    @Test
    public void whenCompareTwoHashMapUsingStream_thenSuccess() {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        sMap.put('a', 1);
        sMap.put('b', 0);
        sMap.put('c', 3);

        tMap.put('c', 3);
        tMap.put('a', 1);
        tMap.put('b', 0);

        assertTrue(sMap.entrySet().stream().allMatch(e->e.getValue().equals(tMap.get(e.getKey()))));

        Map<String, String[]> first = new HashMap<>();
        Map<String, String[]> second = new HashMap<>();

        first.put("abc", new String[]{"China", "Japan"});
        first.put("def", new String[]{"1", "2", "3"});

        second.put("def", new String[]{"1", "2", "3"});
        second.put("abc", new String[]{"China", "Japan"});

        assertTrue(first.entrySet().stream().allMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey()))));
    }

    @Test
    public void whenCompareTwoHashMapKeys_thenSuccess() {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        sMap.put('a', 1);
        sMap.put('b', 0);
        sMap.put('c', 3);

        tMap.put('c', 3);
        tMap.put('a', 1);
        tMap.put('b', 0);

        assertTrue(sMap.keySet().equals(tMap.keySet()));
    }

    private Map<String, Boolean> areEqualKeyValues(Map<String, String> first, Map<String, String> second) {
        return first.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().equals(second.get(e.getKey()))));
    }

    @Test
    public void whenCompareTwoHashMapKeyValuesUsingStreamAPI_thenSuccess() {
        Map<String, String> asiaCapital3 = new HashMap<String, String>();
        asiaCapital3.put("Japan", "Tokyo");
        asiaCapital3.put("South Korea", "Seoul");
        asiaCapital3.put("China", "Beijing");

        Map<String, String> asiaCapital4 = new HashMap<String, String>();
        asiaCapital4.put("South Korea", "Seoul");
        asiaCapital4.put("Japan", "Osaka");
        asiaCapital4.put("China", "Beijing");

        Map<String, Boolean> result = areEqualKeyValues(asiaCapital3, asiaCapital4);

        assertEquals(3, result.size());
        assertFalse(result.get("Japan"));
        assertTrue(result.get("South Korea"));
        assertTrue(result.get("China"));
    }

    @Test
    public void givenDifferentMaps_whenGetDiffUsingGuava_thenSuccess() {
        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");

        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");

        MapDifference<String, String> diff = Maps.difference(asia1, asia2);
        Map<String, MapDifference.ValueDifference<String>> entriesDiffering = diff.entriesDiffering();

        assertFalse(diff.areEqual());
        assertEquals(1, entriesDiffering.size());
        assertNotNull(entriesDiffering.get("India"));
        assertEquals("New Delhi", entriesDiffering.get("India").leftValue());
        assertEquals("Delhi", entriesDiffering.get("India").rightValue());
    }

    @Test
    public void givenDifferentMaps_whenGetEntriesOnOneSideUsingGuava_thenSuccess() {
        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");

        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");

        MapDifference<String, String> diff = Maps.difference(asia1, asia2);
        Map<String, String> entriesOnlyOnRight = diff.entriesOnlyOnRight();
        Map<String, String> entriesOnlyOnLeft = diff.entriesOnlyOnLeft();

        assertEquals(1, entriesOnlyOnRight.size());
        assertEquals(1, entriesOnlyOnLeft.size());
        assertEquals(entriesOnlyOnRight.get("China"), "Beijing");
        assertEquals(entriesOnlyOnLeft.get("South Korea"), "Seoul");
    }

    @Test
    public void givenDifferentMaps_whenGetCommonEntriesUsingGuava_thenSuccess() {
        Map<String, String> asia1 = new HashMap<String, String>();
        asia1.put("Japan", "Tokyo");
        asia1.put("South Korea", "Seoul");
        asia1.put("India", "New Delhi");

        Map<String, String> asia2 = new HashMap<String, String>();
        asia2.put("Japan", "Tokyo");
        asia2.put("China", "Beijing");
        asia2.put("India", "Delhi");

        MapDifference<String, String> diff = Maps.difference(asia1, asia2);
        Map<String, String> entriesInCommon = diff.entriesInCommon();

        assertEquals(1, entriesInCommon.size());
        assertEquals(entriesInCommon.get("Japan"),"Tokyo");
    }

    @Test
    public void givenSimilarMapsWithArrayValue_whenCompareUsingGuava_thenFail() {
        Map<String, String[]> asiaCity1 = new HashMap<String, String[]>();
        asiaCity1.put("Japan", new String[] { "Tokyo", "Osaka" });
        asiaCity1.put("South Korea", new String[] { "Seoul", "Busan" });

        Map<String, String[]> asiaCity2 = new HashMap<String, String[]>();
        asiaCity2.put("South Korea", new String[] { "Seoul", "Busan" });
        asiaCity2.put("Japan", new String[] { "Tokyo", "Osaka" });

        MapDifference<String, String[]> diff = Maps.difference(asiaCity1, asiaCity2);
        assertFalse(diff.areEqual());
    }

    @Test
    public void givenSimilarMapsWithArrayValue_whenCompareUsingGuavaEquivalence_thenSuccess() {
        Map<String, String[]> asiaCity1 = new HashMap<String, String[]>();
        asiaCity1.put("Japan", new String[] { "Tokyo", "Osaka" });
        asiaCity1.put("South Korea", new String[] { "Seoul", "Busan" });

        Map<String, String[]> asiaCity2 = new HashMap<String, String[]>();
        asiaCity2.put("South Korea", new String[] { "Seoul", "Busan" });
        asiaCity2.put("Japan", new String[] { "Tokyo", "Osaka" });

        Map<String, String[]> asiaCity3 = new HashMap<String, String[]>();
        asiaCity3.put("South Korea", new String[] { "Seoul", "Busan" });
        asiaCity3.put("Japan", new String[] { "Tokyo", "Osaka", "Yokohama" });

        Equivalence<String[]> eq = new Equivalence<String[]>() {
            @Override
            protected boolean doEquivalent(String[] a, String[] b) {
                return Arrays.equals(a, b);
            }

            @Override
            protected int doHash(String[] value) {
                return value.hashCode();
            }
        };

        MapDifference<String, String[]> diff = Maps.difference(asiaCity1, asiaCity2, eq);
        assertTrue(diff.areEqual());

        diff = Maps.difference(asiaCity1, asiaCity3, eq);
        assertFalse(diff.areEqual());
    }
}
