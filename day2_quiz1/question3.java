package day2_quiz1;
import java.util.*;

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd;
}
public class question3 {
 

    public static List<String> ClubbedWords(String[] words) {
        List<String> result = new ArrayList<>();
        Node root = new Node();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (isClubbedWord(word, root, 0, 0)) {
                result.add(word);
            }
            insertWord(root, word);
        }

        return result;
    }

    private static void insertWord(Node root, String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Node());
            current = current.children.get(ch);
        }
        current.isEnd = true;
    }

    private static boolean isClubbedWord(String word, Node root, int start, int count) {
        Node current = root;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
            if (current.isEnd) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (isClubbedWord(word, root, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] words = new String[n];
        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine().trim();
        }

        List<String> clubbedWords = ClubbedWords(words);

        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Clubbed Words: " + clubbedWords);

        scanner.close();
    }
}
