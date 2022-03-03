package dev.betpawa.algo.random;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FileScrapper {


    public static void main(String[] args) throws FileNotFoundException {
        String str = "I am here";

        String[] temp = str.split(" ");

        System.out.println(Arrays.stream(temp).collect(Collectors.joining("-")));

        File file = new File("..\\..\\..\\loremText.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));



        var sm = reader.lines().collect(Collectors.joining(" ")).toLowerCase();

        Map<String, Long> scrapedLetters = processedString2(str);
        System.out.println();
        System.out.println(scrapedLetters);
        System.out.println();
        System.out.println("Scraping textFile");
        System.out.println(processedString2(sm));
        System.out.println();
        System.out.println();
        System.out.println(processedString(sm));
    }

    private static Map<String, Long> processedString2(String str) {
        return Arrays.stream(str.split(" "))
                .collect(groupingBy(word -> word, counting()));
    }

    private static Map<String, Long> processedString(String str) {
        return str.chars()
                  .filter(Character::isAlphabetic)
                  .mapToObj(codePoint -> Character.toString((char) codePoint))
                  .collect(groupingBy(letters -> letters, counting()));
    }
}
