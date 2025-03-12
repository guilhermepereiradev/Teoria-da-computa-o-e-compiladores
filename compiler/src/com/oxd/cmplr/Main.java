package src.com.oxd.cmplr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Token> tokens = new ArrayList<>();
        
        String KEYWORDS = "\\b(if|else|while|for|return|int|float|double|char|void)\\b";
        String IDENTIFIER = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
        String NUMBER = "\\b\\d+(\\.\\d+)?\\b";
        String OPERATOR = "[+\\-*/=<>!]+";
        String SYMBOL = "[{}();,]";

        Pattern pattern = Pattern.compile(
                "(?<KEYWORDS>" + KEYWORDS + ")|" +
                        "(?<IDENTIFIER>" + IDENTIFIER + ")|" +
                        "(?<NUMBER>" + NUMBER + ")|" +
                        "(?<OPERATOR>" + OPERATOR + ")|" +
                        "(?<SYMBOL>" + SYMBOL + ")"
        );

        String code = """
                        int x = 10;
                        if (x > 1) { 
                            return x + 1; 
                        }
                """;
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            if (matcher.group("KEYWORDS") != null) {
                tokens.add( new Token("KEYWORD", matcher.group("KEYWORDS")));
            }
            if (matcher.group("IDENTIFIER") != null) {
                tokens.add( new Token("IDENTIFIER", matcher.group("IDENTIFIER")));
            }
            if (matcher.group("NUMBER") != null) {
                tokens.add( new Token("NUMBER", matcher.group("NUMBER")));
            }
            if (matcher.group("OPERATOR") != null) {
                tokens.add( new Token("OPERATOR", matcher.group("OPERATOR")));
            }
            if (matcher.group("SYMBOL") != null) {
                tokens.add(new Token("SYMBOL", matcher.group("SYMBOL")));
            }
        }

        tokens.forEach(System.out::println);
    }
}