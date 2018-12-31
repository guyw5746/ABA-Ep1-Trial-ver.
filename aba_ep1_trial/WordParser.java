package com.example.a9011_20.aba_ep1_trial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a9011_20.aba_ep1_trial.sql.SQLiteHelper;

import java.util.ArrayList;

public class WordParser {
    // 입력되는 한글을 초장, 중장, 종장으로 나눠서 계산하는 클래스.

    ArrayList<Word> wordList;


    char [] consData = {'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
    char [] vowelsData = {'ㅏ','ㅐ','ㅑ','ㅒ','ㅓ','ㅔ','ㅕ','ㅖ','ㅗ','ㅘ','ㅙ','ㅚ','ㅛ','ㅜ','ㅝ','ㅞ','ㅟ','ㅠ','ㅡ','ㅢ','ㅣ'};
    char [] supportsData = {' ','ㄱ','ㄲ','ㄳ','ㄴ','ㄵ','ㄶ','ㄷ','ㄹ','ㄺ','ㄻ','ㄼ','ㄽ','ㄾ','ㄿ','ㅀ','ㅁ','ㅂ','ㅄ','ㅅ','ㅆ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};

    public WordParser(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    public ArrayList<Word> wordSet(char data, int position, int type) {
        ArrayList<Word> chooseList = new ArrayList<>();

        for(Word wordData:wordList){


            String word = wordData.getData();
            boolean check = false;
            switch (position){
                case 0:
                    if(checkWord(data,word.charAt(0),type)){
                        check = true;
                    }
                    break;
                case 1:
                    if(checkWord(data,word.substring(1,word.length()-1),type)){
                        check = true;
                    }
                    break;
                case 2:
                    if(checkWord(data,word.charAt(word.length()-1),type)){
                        check = true;
                    }
                    break;
            }

            if(check){
                chooseList.add(wordData);
            }
        }

        return chooseList;
    }

    public boolean checkWord(char data, char piece, int type){

        int temp = piece - 44032;

        int support = temp % 28;
        int vowel = ((temp - support) / 28) % 21;
        int consonant = (((temp - support) / 28) - vowel) / 21;

        switch (type){
            case 0:
                if(data==consData[consonant]){
                    return true;
                }
                break;
            case 1:
                if(data==vowelsData[vowel]){
                    return true;
                }
                break;
            case 2:
                if(data==supportsData[support]){
                    return true;
                }
                break;
        }
        return false;

    }

    public boolean checkWord(char data, String piece, int type){

        for(int i=0;i<piece.length();i++){
            char bit = piece.charAt(i);

            int temp = bit - 44032;

            int support = temp % 28;
            int vowel = ((temp - support) / 28) % 21;
            int consonant = (((temp - support) / 28) - vowel) / 21;

            switch (type){
                case 0:
                    if(data==consData[consonant]){
                        return true;
                    }
                    break;
                case 1:
                    if(data==vowelsData[vowel]){
                        return true;
                    }
                    break;
                case 2:
                    if(data==supportsData[support]){
                        return true;
                    }
                    break;
            }
        }
        return false;
    }



}
