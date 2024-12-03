import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*Задание 1
        Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
        Код должен работать с любой последовательностью и объемом списка чисел.
         */

        System.out.println("Задача 1");
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        task1(nums);
        System.out.println();

        /* Задание 2
        Напишите код, с помощью которого можно напечатать только четные числа без повторений в
        порядке возрастания. Код должен работать с любой последовательностью и объемом списка
        чисел.
         */
        System.out.println("Задача 2");
        Collections.sort(nums);
        List<Integer> newNums = removeDuplicates(nums);
        task2(newNums);
        System.out.println();

        /* Задание 3
        Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором
        могут встречаться дубли. Код должен работать с любой последовательностью и объемом списка слов.
        В качестве отладочной информации возьмите произвольный набор слов или текст, в котором
        встречаются повторения.
         */
        System.out.println("Задача 3");
        List<String> words = new ArrayList<>(List.of("один", "два", "два", "три", "три", "три"));
        // 1 вариант решения задачи
        List<String> newWords = removeDuplicates(words);
        System.out.println("1 вариант решения задачи");
        System.out.println(newWords);
        // 2 вариант решения задачи, если не важен порядок элементов
        Set<String> newWords2 = new HashSet<>(words);
        System.out.println("2 вариант решения задачи");
        System.out.println(newWords2);

        /* Задание 4
        Напишите код, который выводит в консоль количество дублей для каждого уникального слова. Код
        должен работать с любой последовательностью и объемом списка слов.
         */
        System.out.println("Задача 4");
        //1 вариант решение задачи
        Map<String, Integer> mapCount = countByClassicalLoop(words);
        System.out.println(mapCount);
        // 2 вариант решение задачи
        List<String> strings = new ArrayList<>(List.of("один", "два", "два", "три", "три", "три"));
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : strings) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        for (int count : wordCounts.values()) {
            System.out.println(count);
        }


    }

    public static void task1(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number);
                System.out.print(" ");
            }
        }
    }

    public static void task2(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number);
                System.out.print(" ");
            }
        }
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static <T> Map<T, Integer> countByClassicalLoop(Collection<T> inputList) {
        Map<T, Integer> resultMap = new HashMap<>();
        for (T element : inputList) {
            if (resultMap.containsKey(element)) {
                resultMap.put(element, resultMap.get(element) + 1);
            } else {
                resultMap.put(element, 1);
            }
        }
        return resultMap;
    }
}
