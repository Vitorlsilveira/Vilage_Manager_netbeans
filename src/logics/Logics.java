package logics;

public class Logics {
    
    public String getSexFromId(String id){
 
        String sexStr = id.substring(2,5);
        int sexInt = Integer.parseInt(sexStr);
        if(sexInt < 500){
            return "Male";
        }
        return "Female";
    }
}
