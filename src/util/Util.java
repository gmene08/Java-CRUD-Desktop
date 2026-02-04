package util;
public class Util {
    public static String numeroValido(String t){
        return t==null||t.isEmpty()||!t.matches("[0-9.]+")?"0":t;
    }
    
}
