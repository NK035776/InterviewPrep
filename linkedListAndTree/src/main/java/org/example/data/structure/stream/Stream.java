package org.example.data.structure.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public static List<Hosting> listToMap() {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        Map<Integer, String> result1 = list
                .stream()
                .collect(Collectors.toMap(Hosting::getId, Hosting::getName));

        Map<String, Long> result2 = list
                .stream()
                .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        Map<Integer, String> result3 = list
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        return list;
    }

    public static List<Hosting> listToMapDuplicateKeys() {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        list.add(new Hosting(6, "linode.com", 100000)); // new line

        Map<String, Long> result1 = list
                .stream()
                .collect(Collectors
                        .toMap(Hosting::getName,
                                Hosting::getWebsites, (webSite1, webSite2) -> webSite1));


//        persons.stream()
//                .collect(Collectors.groupingBy(Person::getNationality, Collectors.collectingAndThen(
//                        Collectors.maxBy(Comparator.comparingInt(Person::getAge)),
//                        o -> o.get().getName())));

        System.out.println(result1);
        return list;
    }

    public static List<Hosting> listToMapSort() {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000));

        Map<String, Long> result1 = list
                .stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(Collectors
                        .toMap(Hosting::getName, Hosting::getWebsites,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new));

        return list;
    }

    public static void listToFlatMap() {
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
                listOfListofInts);

        // Using flatMap for transformation and flattening.
        List<Integer> listOfInts  = listOfListofInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " +
                listOfInts);
    }

}
