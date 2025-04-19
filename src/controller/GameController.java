package controller;

import service.GameService;

import java.util.Scanner;

public class GameController {
    private final GameService gameService;
    private final Scanner scanner = new Scanner(System.in);

    public GameController() {
        this.gameService = new GameService();
    }
    public void start() throws InterruptedException {
        String word = gameService.getWord();

            System.out.println("Игра началась,размер слова - " + word.length());
            System.out.println(gameService.encryptionWord());
        while(!gameService.gameOver()){
            char symbol = scanner.next().charAt(0);

            gameService.updateWord(symbol);
            if (gameService.userIsFall){
                Thread.sleep(1000);
                System.out.println("У вас не осталось попыток,вы проиграли,слово было: " + gameService.getWord());
                return;
            }
        }
        if(gameService.gameOver()){
            Thread.sleep(1000);
            System.out.println("Вы угадали слово,вы победили");
        }
    }
}
