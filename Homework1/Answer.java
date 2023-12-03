package Homework1;

public class Answer {
    public void printPrimeNums(){
        boolean isPrime; 
        for(int i = 2; i < 1000; i++) { 
            isPrime = i == 1; 
            for(int j = 2; j < 1000; j++) { 
                if (i >= j && i % j == 0) { 
                    if(j == i) { 
                        isPrime = true;
                    } break; 
                } 
            } if(isPrime) System.out.println(i); 
        } 
    } 
}
  
  // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
  public class Printer{ 
      public static void main(String[] args) { 
        
        Answer ans = new Answer();      
        ans.printPrimeNums();
      }
  }
}
