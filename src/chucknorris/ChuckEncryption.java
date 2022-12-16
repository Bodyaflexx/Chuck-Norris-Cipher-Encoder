package chucknorris;

public class ChuckEncryption {
    String text;

    public ChuckEncryption(String text) {
        this.text = text;
    }

    public String print(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(text.charAt(i));
            result.append(' ');
        }
        return result.toString();
    }


    public int length() {
        return this.text.length();
    }

    public char getChar(int index) {
        return text.charAt(index);
    }

    public String encryption(char symbol) {
        return String.format("%7s", Integer.toBinaryString(symbol)).replace(" ", "0");
    }

    public String chuckNorisEncryption() {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            StringBuilder temp = new StringBuilder();
            if (text.charAt(i) == '1') {
                temp.append("0 ");
                while (text.charAt(i) == '1') {
                    temp.append("0");
                    i++;
                    if (i == text.length()) {
                        break;
                    }
                }
                result.append(temp);
            } else if (text.charAt(i) == '0') {
                temp.append("00 ");
                while (text.charAt(i) == '0') {
                    temp.append("0");
                    i++;
                    if (i == text.length()) {
                        break;
                    }
                }
                result.append(temp);
            }
            result.append(" ");
        }
        return result.toString();
    }
}
