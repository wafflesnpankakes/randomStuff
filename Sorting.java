//Name: Emilie Spindler
//Date: 2.5.2025
//Description: This class contains a method that sorts an array of integers from lowest to highest value

public class Sorting {

    //precondition: input has been declared and contains at least one element
    //postcondition: an array containing all the elements of input in ascending order is returned.
    private static int[] sort(int[] input) {
   	 //your code goes here

        for(int i=0; i<input.length-1; i++){
            int smallest = input[i];
            int index = i;

            for(int k=i+1; k<input.length; k++){

                if(input[k] < smallest){
                smallest = input[k];
                index = k;
                }
            }

            input[index] = input[i];
            input[i] = smallest;
        }
        return input;
    }
    
    public static void main(String[] args) {
   	 System.out.println("Try to sort [8,2,9,1,0,2,-3, 233]");
   	 int[] input = {8,2,9,1,0,2,-3,233};
   	 int[] result = sort(input);
   	 for(int i=0; i<result.length; i++) {
   		 System.out.print(result[i]+ (i == result.length-1 ? "":", "));
   	 }
   	 System.out.print(" is the result and it should read [-3,0,1,2,2,8,9,233]");
    }
}