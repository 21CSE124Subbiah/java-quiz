package day3_quiz1;
import java.util.*;

public class question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the array separated by space: ");
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter the partition size: ");
        int partitionSize = scanner.nextInt();
        List<Integer> partitionOrder = new ArrayList<>();

        System.out.print("Enter the partition order separated by space: ");
        for (int i = 0; i < array.length / partitionSize; i++) {
            partitionOrder.add(scanner.nextInt());
        }

        int[] result = Merge(array, partitionSize, partitionOrder);

        System.out.print("Output: ");
        Arrays.stream(result).forEach(num -> System.out.print(num + " "));
        scanner.close();
    }

    private static int[] Merge(int[] array, int partitionSize, List<Integer> partitionOrder) {
        List<List<Integer>> partitions = new ArrayList<>();

        for (int i = 0; i < array.length; i += partitionSize) {
            List<Integer> partition = new ArrayList<>();
            for (int j = 0; j < partitionSize && i + j < array.length; j++) {
                partition.add(array[i + j]);
            }
            partitions.add(partition);
        }

        Collections.sort(partitions, (a, b) -> {
            for (int order : partitionOrder) {
                int aValue = (order - 1 < a.size()) ? a.get(order - 1) : Integer.MAX_VALUE;
                int bValue = (order - 1 < b.size()) ? b.get(order - 1) : Integer.MAX_VALUE;

                if (aValue != bValue) {
                    return Integer.compare(bValue, aValue);
                }
            }
            return 0;
        });

        int[] result = new int[array.length];
        int index = 0;

        for (List<Integer> partition : partitions) {
            for (int num : partition) {
                result[index++] = num;
            }
        }

        return result;
    }
}

