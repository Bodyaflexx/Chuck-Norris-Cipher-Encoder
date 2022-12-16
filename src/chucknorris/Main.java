package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String answer = scanner.nextLine();
            switch (answer) {
                case "encode": {
                    System.out.println("Input string:");
                    ChuckEncryption text = new ChuckEncryption(scanner.nextLine());
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        String binary = text.encryption(text.getChar(i));
                        result.append(binary);
                    }
                    ChuckEncryption res = new ChuckEncryption(result.toString());
                    System.out.println("Encoded string:");
                    System.out.println(res.chuckNorisEncryption());
                    break;
                }
                case "decode": {
                    System.out.println("Input encoded string:");
                    ChuckDecoder text = new ChuckDecoder(scanner.nextLine());
                    if (!text.isCheckOnValid()) {
                        System.out.println("not valid");
                    } else {
                        System.out.println("Decoded string:");
                        String[] temp = text.decoderToBinary().split("(?<=\\G.{7})");
                        ChuckDecoder binary = new ChuckDecoder(temp);
                        binary.decoderToSymbols();
                    }
                    break;
                }
                case "exit":
                    System.out.println("Bye!");
                    break label;
                default:
                    System.out.println("There is no '" + answer + "' operation");
                    break;
            }
        }
    }
}