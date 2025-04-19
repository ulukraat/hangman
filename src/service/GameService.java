package service;

import repository.WordRepository;

public class GameService {
    private String word;
    private String currentState;

    public GameService() {
        this.word = WordRepository.INSTANCE.getRandom();
        this.currentState = encryptionWord();
    }

    public String getWord() {
        return word;
    }
    public String getCurrentState() {
        return currentState;
    }

    public String encryptionWord(){
        return word.replaceAll(".","_");

    }
    private int fallCounter = 0;

    public void updateWord(char letter){
        StringBuilder updatedWord = new StringBuilder(currentState);
        int tryCounter = 5;
        boolean found = false;

            if(word.contains(String.valueOf(letter))){
                System.out.println("Вы нашли букву");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        if (updatedWord.charAt(i) != letter) {
                            updatedWord.setCharAt(i, letter);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    System.out.println("Это буква уже была угадана");
                }else {
                    System.out.println(updatedWord);
                }
            }
            else {
                System.out.println("Такого символа в букве нет,у вас осталось " + (tryCounter - fallCounter)  + " попыток");
                fallCounter++;
                if (fallCounter > 5) {
                    userIsFall = true;
                    return;
                }
            }

        currentState = updatedWord.toString();
    }
    public boolean gameOver(){
        return !currentState.contains("_");
    }
    public boolean userIsFall = false;
}

