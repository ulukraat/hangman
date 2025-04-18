package controller;

import service.GameService;

import java.util.Scanner;

public class GameController {
    private final GameService gameService;
    private final Scanner scanner = new Scanner(System.in);

    public GameController() {
        this.gameService = new GameService();
    }
    public void start(){
        String word = gameService.getWord();

            System.out.println("Игра началась,размер слова - " + word.length());
            System.out.println(gameService.encryptionWord());
        while(!gameService.gameOver()){
            char symbol = scanner.next().charAt(0);

            gameService.updateWord(symbol);
            if (gameService.userIsFall){
                return;
            }
        }


    }
}
