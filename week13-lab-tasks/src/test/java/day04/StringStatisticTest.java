package day04;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticTest {

    @Test
    void stringStatisticTest() {

        StringStatistic statistic = new StringStatistic();
        Map<Character, Integer> expected = statistic.vowelCounter("appluetruee");

        assertEquals(1, expected.get('a'));
        assertNull(expected.get('o'));

        Map<Character, Integer> expected2 = statistic.vowelCounter2("appluetruee");

        assertEquals(1, expected2.get('a'));
        assertNull(expected2.get('o'));

        for (Map.Entry<Character, Integer> actual : expected.entrySet()) {
            System.out.println(actual.getKey() + " " + actual.getValue());
        }
        System.out.println();
    }

    // Map-et value szerint rendez lamda-kkal:
    @Test
    public void mapOrderingByValue() {
        StringStatistic stringStatistic = new StringStatistic();

        Map<Character, Integer> result = stringStatistic.vowelCounter("appluetruee");

        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(result.entrySet());

        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));

        /* Ez ugyanaz, mint az előző sor:
        Collections.sort(entryList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        */

        /* Ez is ugyanaz, mint a kettővel előtti sor:
       Collections.sort(entryList, new Comparator<Map.Entry <Character, Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
         */

        // az a sort() eredményének a kiíratása:
        for (Map.Entry<Character, Integer> actual : entryList) {
            System.out.println(actual.getKey() + " " + actual.getValue());
        }
        System.out.println();
    }

}