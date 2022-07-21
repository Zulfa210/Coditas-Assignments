package week1.day2;

public class Addition_Of_Variables {

    public void addInt()
    {
        int intVariable1 = 10;
        int intVariable2 = 20;
        //adding two int variables
        int intSum = intVariable1 + intVariable2;
        System.out.println(intSum);
    }

    public void addShort(){
        short shortVariable1 = 10;
        short shortVariable2 = 20;

        //adding two short variables return an int variable
        int shortSum = shortVariable1 + shortVariable2;
        System.out.println(shortSum);
    }

    public void addLong(){
        long longVariable1 = 10;
        long longVariable2 = 20;

        //adding two long variables
        long longSum = longVariable1 + longVariable2;
        System.out.println(longSum);
    }

    public void addFloat(){
        float floatVariable1 = 10;
        float floatVariable2 = 20;

        //adding two float variables
        float floatSum = floatVariable1 + floatVariable2;
        System.out.println(floatSum);
    }
    public void addDouble(){
        double doubleVariable1 = 10;
        double doubleVariable2 = 20;

        //adding two double variables
        double doubleSum = doubleVariable1 + doubleVariable2;
        System.out.println(doubleSum);
    }

    public void addByte(){
        byte byteVariable1 = 1;
        byte byteVariable2 = 1;

        //adding two byte variable gives int, hence we need to typecast it to byte
        byte byteSum = (byte)(byteVariable1 + byteVariable2);
        System.out.println(byteSum);
    }

    public void addChar(){
        char charVariable1 = 'a';
        char charVariable2 = 'b';

        //adding two char variables adds ascii values, hence int is returned
        //we need to typecast it to char
        char charSum = (char)(charVariable1 + charVariable2);
        System.out.println(charSum);
    }


    public void addBoolean(){
        boolean boolVariable1 = false;
        boolean boolVariable2 = true;

        //bool value cannot be added
        //boolean boolSum = boolVariable1 + boolVariable2;
        //System.out.println(boolSum);
    }
    public static void main(String args[]){
        Addition_Of_Variables addition = new Addition_Of_Variables();

        addition.addInt();
        addition.addShort();
        addition.addLong();
        addition.addFloat();
        addition.addDouble();
        addition.addChar();
        addition.addBoolean();
        addition.addByte();

    }
}
