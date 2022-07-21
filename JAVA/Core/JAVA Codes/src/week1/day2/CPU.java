package week1.day2;



  public  class CPU {
        double price;
        // nested class
        class Processor{
            // members of nested class
            double cores;
            String manufacturer;
            double getCache(){
                return 4.3;
            }
        }
        // nested protected class
        protected class RAM{
            // members of protected nested class
            double memory;
            String manufacturer;
            double getClockSpeed(){
                return 5.5;
            }
        }
    }

    class Main{
       public static void main(String args[]){


           CPU C = new CPU();  //object of outer class

           CPU.Processor processorObj = C.new Processor(); //object of nested class Processor
           System.out.println(processorObj.getCache());


           CPU.RAM r= C.new RAM();  //object of protected nested class
           System.out.println(r.getClockSpeed());
       }
    }


