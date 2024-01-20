package org.fi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class TrieNode {
    // Existing TrieNode code remains unchanged
}

class Trie {
    // Existing Trie code remains unchanged
}

public class Approximate_Search {

    public static void main(String[] args) {
        Trie trie = new Trie();
        try {
            loadWordsFromFile(trie, "wordlist.txt");
        } catch (IOException e) {
            System.err.println("Error loading words from file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a word (type 'exit' to quit): ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("exit")) {
                break;
            }

            System.out.print("Enter the value of k: ");
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            List<String> suggestions = trie.search(userInput, k);

            System.out.println("Suggestions: " + suggestions);
        }

        scanner.close();
    }

    private static void loadWordsFromFile(Trie trie, String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim().toLowerCase();
                trie.insert(word);
            }
        }
    }
}
