package hbcu.stay.ready.algor;

import java.util.HashMap;

public class Solution {

    public Boolean harmlessRansomNote(String message , String magazineText){
        // we instantiate a hashmap that we will use to track the word count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        // first we split the magazine text into an array separated by spaces
        String[] magazineArray = magazineText.split(" ");

        // loop through the words in array and put them in the hashmap
        for (String eachWord : magazineArray) {
            // if hashmap encounters a word again it increments the value
            if (wordCount.containsKey(eachWord)){
                Integer wordValue = wordCount.get(eachWord);
                wordValue++;
                wordCount.put(eachWord, wordValue);
            // else if hashmap is yet encounter the word, it adds the word and set its value to 1
            } else {
                wordCount.put(eachWord, 1);
            }
        }

        System.out.println(wordCount);
        // splitting the ransome message into an array separated by spaces
        String[] messageArray = message.split(" ");
        for (String word : messageArray){
            if (!wordCount.containsKey(word) || wordCount.get(word) < 1){
                return false;
            } else {
                Integer wordValue1 = wordCount.get(word);
                wordValue1--;
                wordCount.put(word, wordValue1);
            }
        }

        return true;
    }
}
