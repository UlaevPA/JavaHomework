package Homework4;



public class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder str = new StringBuilder();
        String params = PARAMS.replace('{', ' ').replace('}', ' ');
        String[] prms = params.split(",");
        for (int i = 0; i < prms.length; i++){
          String[] elements = prms[i].replace('"', ' ').split(":");
          if(!"null".equals(elements[1].trim())){
            str.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
            
              if (i < prms.length - 2){
                str.append(" and ");              
              } 
          }
        }
        return str;


    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
    
}
