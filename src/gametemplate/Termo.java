package gametemplate;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Termo extends Game {
    private GameData gameData;
    private File saveFile;

    public Termo() {
        saveFile = new File("save.txt");
    }

    @Override
    public void criaNovo() {
        String[] palavras = {"java", "javo", "jave", "javu", "javi"};
        Random rand = new Random();
        gameData = new GameData();
        gameData.palavraAdivinhar = palavras[rand.nextInt(palavras.length)];
        gameData.tentativas = 6;
        gameData.tentativasAnteriores = new StringBuilder(); // Usamos um StringBuilder para armazenar tentativas anteriores
        boolean ganhou = false;

        System.out.println("Bem-vindo ao Termo");
        System.out.println("Tente adivinhar a palavra. Ela tem " + gameData.palavraAdivinhar.length() + " letras.");

        Scanner scanner = new Scanner(System.in);

        while (gameData.tentativas > 0) {
            System.out.println("Tentativas restantes: " + gameData.tentativas);

            String palavraDigitada;
            do {
                System.out.print("Digite uma palavra (" + gameData.palavraAdivinhar.length() + " letras): ");
                palavraDigitada = scanner.next();
                if (palavraDigitada.length() != gameData.palavraAdivinhar.length()) {
                    System.out.println("A palavra deve ter o mesmo tamanho da palavra a ser adivinhada.");
                }
            } while (palavraDigitada.length() != gameData.palavraAdivinhar.length());

            gameData.tentativasAnteriores.append(palavraDigitada).append("\n"); // Adiciona a tentativa anterior ao StringBuilder

            for (int i = 0; i < gameData.palavraAdivinhar.length(); i++) {
                char letraAdivinhar = gameData.palavraAdivinhar.charAt(i);
                char letraDigitada = palavraDigitada.charAt(i);

                if (letraDigitada == letraAdivinhar) {
                    System.out.print("\u001B[32m" + letraDigitada + "\u001B[0m");
                } else if (palavraDigitada.contains(String.valueOf(letraAdivinhar))) {
                    System.out.print("\u001B[33m" + letraDigitada + "\u001B[0m");
                } else {
                    System.out.print("\u001B[31m" + letraDigitada + "\u001B[0m");
                }
            }

            System.out.println();

            if (palavraDigitada.equals(gameData.palavraAdivinhar)) {
                ganhou = true;
                break;
            } else {
                System.out.println("\u001B[31mPalavra incorreta!\u001B[0m");
                gameData.tentativas--;
            }

            // Salve o estado do jogo
            salvarJogo(gameData);
            
            // Exibe as tentativas anteriores
            if (gameData.tentativasAnteriores.length() > 0) {
                System.out.println("Tentativas anteriores:");
                System.out.println(gameData.tentativasAnteriores.toString());
            }
        }

        // Apague o arquivo de salvamento após o jogo terminar
        saveFile.delete();

        if (ganhou) {
            System.out.println("Parabéns! Você ganhou. A palavra era: " + gameData.palavraAdivinhar);
        } else {
            System.out.println("Suas tentativas acabaram. Tente novamente! A palavra era: " + gameData.palavraAdivinhar);
        }

        Scanner teclado = new Scanner(System.in);

        System.out.println("Deseja jogar novamente?");
        System.out.println("1- Sim");
        System.out.println("2- Não (Sair)");

        int entrada = teclado.nextInt();

        switch (entrada) {
            case 1:
                criaNovo();
                break;
            case 2:
                sai();
                break;
            default:
                throw new InputMismatchException("entrada inválida");
        }
    }

    @Override
    public void executa() {
    }

    @Override
    public void carrega() {
        if (saveFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
                gameData = (GameData) ois.readObject();
                System.out.println("Jogo carregado a partir do estado anterior.");
                System.out.println("Tentativas restantes: " + gameData.tentativas);
                if (gameData.tentativasAnteriores.length() > 0) {
                    System.out.println("Tentativas anteriores:");
                    System.out.println(gameData.tentativasAnteriores.toString());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                criaNovo();
            }
        } else {
            criaNovo();
        }
    }

    private static class GameData implements Serializable {
        String palavraAdivinhar;
        int tentativas;
        StringBuilder tentativasAnteriores; // Usamos um StringBuilder para armazenar tentativas anteriores
    }

    private void salvarJogo(GameData gameData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
