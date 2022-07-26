package week2.day6;
//Q5)Try to add 2 Jagged arrays:

class JaggedArray{
    public void AddJaggedArray(int[][] firstArray, int[][] secondArray ){

        for(int i = 0; i< firstArray.length; i++){
            for(int j = 0; j<firstArray[i].length; j++){
                firstArray[i][j] = firstArray[i][j] + secondArray[i][j];
            }
        }
        printJaggedArray(firstArray);

    }

    public void printJaggedArray(int[][] array1){
        for(int i = 0; i< array1.length; i++){
            for(int j = 0; j<array1[i].length; j++){
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }

    }
}
public class Q5_JaggedArrayAddition {

    public static void main(String[] args) {
        int[][] firstArray = {{2, 3, 5 }, {4 , 6}, {1, 5 , 7}};
        int[][] secondArray = {{ 3, 5, 7 }, {5, 8}, {2, 6, 9}};
        //for addition we can use jagged array of same size

        JaggedArray jaggAdd = new JaggedArray();
        System.out.println("First array: ");
        jaggAdd.printJaggedArray(firstArray);

        System.out.println("Second array: ");
        jaggAdd.printJaggedArray(secondArray);

        System.out.println("Jagged array after addition: ");
        jaggAdd.AddJaggedArray(firstArray, secondArray);
    }

}

//output
//First array:
//2 3 5
//4 6
//1 5 7
//Second array:
//3 5 7
//5 8
//2 6 9
//Jagged array after addition:
//5 8 12
//9 14
//3 11 16