package chucknorris;

import java.util.Objects;

public class ChuckDecoder {
    String text;
    String[] binary;

    public ChuckDecoder(String text) {
        this.text = text;
    }

    public ChuckDecoder(String[] binary) {
        this.binary = binary;
    }

    private String findTwoSymbols(int index) {
        return index < text.length() - 1 ? String.valueOf(text.charAt(index)) +
                text.charAt(index + 1) : null;
    }
    private String findThreeSymbols(int index) {
        return index < text.length() - 2 ? String.valueOf(text.charAt(index)) +
                text.charAt(index + 1) + text.charAt(index + 2) : null;
    }

    public String decoderToBinary() {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (findTwoSymbols(i) == null) {
                break;
            }
            if (Objects.equals(findThreeSymbols(i), "00 ")) {
                i += 3;
                while (text.charAt(i) == '0') {
                    result.append('0');
                    i++;
                    if (i >= text.length()) {
                        break;
                    }
                }
            } else if (Objects.equals(findTwoSymbols(i), "0 ")) {
                ++i;
                ++i;
                while (text.charAt(i) == '0') {
                    result.append('1');
                    i++;
                    if (i >= text.length()) {
                        break;
                    }
                }
            } else {
                i++;
            }

        }
        return result.toString();
    }

    public void decoderToSymbols() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length; i++) {
            int base = 1;
            int dec_value = 0;
            for (int j = binary[i].length() - 1; j >= 0; j--) {

                if (binary[i].charAt(j) == '1')
                    dec_value += base;
                base = base * 2;
            }
            result.append((char) dec_value);
        }

        System.out.println(result);
    }

    public boolean isCheckOnValid() {
        int i = 0;
        while (i < text.length()) {
            if (findTwoSymbols(i) == null) {
                break;
            }
            if (Objects.equals(findThreeSymbols(i), "00 ")) {
                i += 3;
                if (i >= text.length()) {
                    break;
                }
                while (text.charAt(i) == '0') {
                    i++;
                    if (i >= text.length()) {
                        break;
                    }
                }
                i++;
            } else if (Objects.equals(findTwoSymbols(i), "0 ")) {
                i += 2;
                if (i >= text.length()) {
                    break;
                }
                while (text.charAt(i) == '0') {
                    i++;
                    if (i >= text.length()) {
                        break;
                    }
                }
                i++;
            } else {
                return false;
            }

        }
        for (i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && text.charAt(i) != '0') {
                return false;
            }
        }
        if (decoderToBinary().length() % 7 != 0) {
            return false;
        }
        return true;
    }
}
