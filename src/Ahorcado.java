import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String secret_word = "smart";
        int max_attempts = 10;
        int attemps = 0;
        boolean was_found = false;

        char[] chars_found = new char[secret_word.length()];

        for (int i = 0; i < chars_found.length; i++) {
            chars_found[i] = '_';
        }

        while (!was_found && attemps < max_attempts) {
            System.out.println(
                    "Palabra a adivinar:" + String.valueOf(chars_found) + " (" + secret_word.length() + " letras)");

            System.out.println("Introduce una letra por favor:");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean right_char = false;

            for (int i = 0; i < secret_word.length(); i++) {
                if (letra == secret_word.charAt(i)) {
                    chars_found[i] = letra;
                    right_char = true;
                }
            }

            if (!right_char) {
                attemps++;
                System.out.println("Incorrecto, te quedan " + (max_attempts - attemps) + " intentos.");
            }

            if (String.valueOf(chars_found).equals(secret_word)) {
                was_found = true;
            }
        }

        if (was_found) {
            System.err.println("¡Felicidades! Has adivinado la palabra secreta: " + secret_word);
        } else {
            System.err.println("Perdiste.");
        }

        scanner.close();
    }
}
