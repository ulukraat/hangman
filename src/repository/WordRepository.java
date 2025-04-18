package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum WordRepository {
    INSTANCE;
    private final List<String> words = new ArrayList<>();

    WordRepository() {
        words.add("яблоко");
        words.add("город");
        words.add("осень");
        words.add("религия");
        words.add("аппартаменты");
        words.add("сон");
        words.add("улица");
        words.add("книга");
        words.add("интернет");
        words.add("япония");
        words.add("обучение");
        words.add("проффессия");
        words.add("деньги");
        words.add("праздник");
        words.add("будущее");
        words.add("банка");
        words.add("огонь");
        words.add("смерть");
    }
    public  String getRandom(){
        return words.get(new Random().nextInt(words.size()));
    }
}
