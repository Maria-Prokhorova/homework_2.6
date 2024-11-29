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
        Collection<Integer> newNums = removeDuplicates(nums);
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
        Collection<String> newWords = removeDuplicates(words);
        System.out.println(newWords);

        /* Задание 4
        Напишите код, который выводит в консоль количество дублей для каждого уникального слова. Код
        должен работать с любой последовательностью и объемом списка слов.
         */
        System.out.println("Задача 4");
        Map<String, Integer> mapCount = countByClassicalLoop(words);
        System.out.println(mapCount);


    }

    public static void task1(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number);
                System.out.print(" ");
            }
        }
    }

    public static void task2(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number);
                System.out.print(" ");
            }
        }
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> list) {
        Collection<T> newList = new ArrayList<>();
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
