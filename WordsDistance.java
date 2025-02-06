// author: Emilie Spindler
// date made: 12.20.24
// description: checks distance of two different words in an array of strings

public class WordsDistance{

    //precondition: 2 <= wordsDict.length <= 3 * 10^4
    //              each word in wordsDict must have a length greater than 0 and less than 11.
    //              all words in wordsDict consists of lowercase English letters.
    //              word1 and word2 are in wordsDict.
    //              word1 and word2 cannot be the same.

    //postcondition: prints out the shortest distance between the words in the array

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int odd = 1;
        int even = 0;
        int[] sample = new int[wordsDict.length];

        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                sample[odd] = i;
                odd+=2;
            }
            if(wordsDict[i].equals(word2)){
                sample[even] = i;
                even+=2;
            }
        }

        int returned = wordsDict.length-1;
        int test = returned;
        for(int j=0; j<sample.length; j++){
            if(j<sample.length-1){
                test = sample[j+1]-sample[j];
            }
            if(test < 0){
                test = -test;
            }
            if(j>1 && sample[j]==0){
                test=returned;
            }
            if(test < returned){
                returned = test;
            }
        }
        return returned;
        }


    public static void main(String[] args){
        String[] mine = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(WordsDistance.shortestDistance(mine, "coding", "practice"));

        System.out.println(WordsDistance.shortestDistance(mine, "makes", "coding"));

    }
}