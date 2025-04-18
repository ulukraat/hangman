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

            if(word.contains(String.valueOf(letter))){
                System.out.println("Вы нашли букву");
                int position = word.indexOf(String.valueOf(letter));
                updatedWord.setCharAt(position,letter);
                System.out.println(updatedWord.toString());
                if(gameOver()){
                   System.out.println("Вы угадали слово");
                   return;
                }
            }else {
                System.out.println("Такого символа в букве нет,у вас осталось " + (tryCounter - fallCounter)  + " попыток");
                fallCounter++;
                if (fallCounter == 5) {
                    System.out.println("У вас не осталось попыток,вы проиграли");
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


