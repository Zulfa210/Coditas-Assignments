package week1;

class OneDArray{
    public void showData(){
        //way1=> declaration
        int marks[] = new int[10];
        for(int i =0; i< marks.length; i++){
            System.out.print(marks[i]);
        }

        //way 2=> initialization
        int rno[] = {1, 2, 3, 4, 5, 6, 7, 8,9, 10};
        for(int index: rno){
            System.out.println(index);
        }

    }
}

class TwoDDArray{

}
class JaggedArray{


    public void showData() {

        int rows[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++){
                System.out.print(rows[i][j]+ " ");
            }
            System.out.println();
        }

    }


}
public class ArrayDemo {

    public static void main(String[] args) {

        OneDArray oneDArray = new OneDArray();
        oneDArray.showData();

        JaggedArray jaggedArray  = new JaggedArray();
        jaggedArray.showData();
    }

}
