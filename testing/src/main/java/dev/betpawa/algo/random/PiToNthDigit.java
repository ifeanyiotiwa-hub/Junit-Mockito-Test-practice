package dev.betpawa.algo.random;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class PiToNthDigit {
    public static void main(String[] args) {
        BigDecimal seven = new BigDecimal(113);
        BigDecimal twentyTwo = new BigDecimal(355);
        BigDecimal pi = twentyTwo.divide(seven, 100, RoundingMode.UP);

        System.out.println("Pi to 1000 decimal Places");
        System.out.println();
        System.out.println(pi);


        String temp = pi.toPlainString();

        Map<Character, Long> characterLongMap = temp.chars().mapToObj(letter -> (char) letter)
                .filter(Character::isDigit)
                .collect(groupingBy(word -> word, counting()));
        System.out.println(characterLongMap);

        System.out.println(characterLongMap.values().stream().mapToLong(l -> l).sum() - 1 + " digits");
    }
}
