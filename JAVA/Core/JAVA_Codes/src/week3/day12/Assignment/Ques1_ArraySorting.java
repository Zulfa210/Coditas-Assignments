package week3.day12.Assignment;
/**1)Accept the strings(HARD CODE VALUES/USER ACCEPTED), as per their length and
 reorder it.*/

class ReorderArray{
    public static void sortArray(String[] names){

        for (int i = 1; i<names.length; i++){

            String temp = names[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < names[j].length())
            {
                names[j+1] = names[j];
                j--;
            }
            names[j+1] = temp;
        }
    }
}


public class Ques1_ArraySorting {
    public static void main(String[] args) {
        String[] names= {"Zulfa", "Anuj", "Abhishek", "Swaraj", "Zaid"};


        //implementing compare method of Comparator interface using anonymous class
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() < o2.length() ? -1 : 1;
//            }
//        });

        ReorderArray.sortArray(names);

        System.out.println("Strings After Reordering: ");
        //printing string array
        for (String name: names) {
            System.out.println(name.toString());
        }

    }
}

//output:
//"C:\Program Files\Java\jdk1.8.0_333\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\lib\idea_rt.jar=51776:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_333\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\rt.jar;C:\Users\Coditas\Desktop\Coditas-Assignments\JAVA\Core\JAVA_Codes\out\production\Basic_Java_Core" week3.day12.Assignment.Ques_ArraySorting
//Strings After Reordering:
//Anuj
//Zaid
//Zulfa
//Swaraj
//Abhishek