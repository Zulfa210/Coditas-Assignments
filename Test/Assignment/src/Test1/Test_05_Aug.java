package Test1;
// test 05 Aug 2022

public class Test_05_Aug {
    public static void main(String[] args) {
        int count =4;
        for(int i=0;i<4;i++){
            int spaceCount= 4-i-1;
            while(spaceCount>0){
                System.out.print(" ");
                spaceCount--;
            }
            int starCount=i+1;
            while(starCount>0){
                System.out.print("* ");
                starCount--;
            }
            System.out.println();
        }
        for(int i=4;i>0;i--){
            int spaceCount= 4-i+1;
            while(spaceCount>0){
                System.out.print(" ");
                spaceCount--;
            }
            int starCount=i-1;
            while(starCount>0){
                System.out.print("* ");
                starCount--;
            }
            System.out.println();
        }

    }
}
