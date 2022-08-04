package week3.day12.Assignment;
/**4) Remove both leading and trailing white space characters from the given string and
//also showcase the Unicode value of the character present at index 5.
*/
class  LeadingAndTrailing{

    public void removeSpaces(String string){
        System.out.println("Original String: \n" + string + '\n');

        //trim() method removes leading and trailing white spaces
        string =string.trim();

        System.out.println("String after removing leading and trailing white spaces: \n"  + string.trim() + '\n');

        //codePointAt()  method returns the unicode value
        System.out.println("Unicode value of character present at index 5 i.e.: "
                + string.charAt(5)+" is : "+ string.codePointAt(5));


    }
}

public class Ques4_Spaces {

    public static void main(String[] args) {
        LeadingAndTrailing object  = new LeadingAndTrailing();

        String full_name = "      Zulfaa  Ayub  Attar      ";

        object.removeSpaces(full_name);
    }
}

//output:
//Original String:
//      Zulfaa  Ayub  Attar
//
//String after removing leading and trailing white spaces:
//Zulfaa  Ayub  Attar
//
//Unicode value of character present at index 5 i.e.: a is : 97
//
//Process finished with exit code 0
