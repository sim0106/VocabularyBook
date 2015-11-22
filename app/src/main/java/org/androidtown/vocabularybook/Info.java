package org.androidtown.vocabularybook;

/**
 * Created by studio on 2015-11-22.
 */
public class Info {
    private int id;
    private String word;
    private String meaning;

    public Info(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public String toString() {
        return String.format("단어 : %s 의미 : %s", word, meaning);
    }
}
