public class LinearSearchSentence {
    public static void main(String[] args) {
        String[] sentences = {
                "This is a test sentence.",
                "The quick brown fox jumps over the lazy dog.",
                "Java is a programming language.",
                "I love coding challenges."
        };

        String word = "Java";
        String result = findSentenceContainingWord(sentences, word);
        System.out.println(result);
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
