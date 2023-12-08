import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, Integer> wordNoteMap;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        wordNoteMap = new HashMap<String, Integer>();

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            if(word.length() >= M) {
                wordNoteMap.put(word, wordNoteMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> wordNoteList = new ArrayList<>(wordNoteMap.keySet());

        Collections.sort(wordNoteList, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if(wordNoteMap.get(word1) != wordNoteMap.get(word2)) {
                    return wordNoteMap.get(word2) - wordNoteMap.get(word1);
                }
                if(word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                }
                return word1.compareTo(word2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String word: wordNoteList) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

/*
Input
12 5
appearance
append
attendance
swim
swift
swift
swift
mouse
wallet
mouse
ice
age

Output
swift
mouse
appearance
attendance
append
wallet
 */