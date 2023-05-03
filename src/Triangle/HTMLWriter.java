
package Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HTMLWriter {
    
    private String htmlResult= "";
    
    private String fileName;

    
   void ParseHtml(String code) throws IOException{
    fileName = code;
    ArrayList<String> matrix = new ArrayList<String>(); // Create an ArrayList objec 
    File file = new File(code);
    Scanner input = new Scanner(file); 
 
    int count = 0;
    while (input.hasNextLine()) {
        String linea = input.nextLine();
        Scanner dos = new Scanner(linea);
        while(dos.hasNext()){
            matrix.add(dos.next());
        }            
        matrix.add("\n");        
    }
Boolean misma=false;
for (String line: matrix){
    
                if(isNumber(line)){
                    line="<font color='#0000cd'>"+line+" "+"</font>";
                }else if(line.contains("!")){
                    line="<p style=\"font-family: 'DejaVu Sans', monospace;\"><font color='#00b300'>"+line;
                    misma=true;
                }else if (line=="\n"){
                    line=" "+"</font>";
                    line+="<br>";
                    misma=false;
                }else if(line.contains("'")){
                 line="<font color='#0000cd'>"+line+" "+"</font>";

                }else if(tokens.contains(line)){
                 line="<b>"+line+" "+"</b>";

                }
                htmlResult=htmlResult+line+" ";
                
            }
            htmlResult=htmlResult+"<br>";

        }
   
   void ParseHtml2(String code) throws IOException{
    fileName = code;
    ArrayList<String> matrix = new ArrayList<String>(); // Create an ArrayList objec 
    File file = new File(code);
    Scanner input = new Scanner(file); 

    int count = 0;
    while (input.hasNextLine()) {
        String linea = input.nextLine();
        ArrayList<String> ll = divisorTokens(linea);
        for(String pol:ll){
            matrix.add(pol);
        }
        
        matrix.add("\n");        
    }
Boolean misma=false;
for (String line: matrix){
    
                if(isNumber(line) && !misma){
                    line="<span class = \"literal\">"+line+" "+"</span>";
                }else if(line.contains("!")){
                    line="<span class = \"comentario\">"+line;
                    misma=true;
                }else if (line=="\n"){
                    line=" "+"</span>";
                    line+="<br>";
                    misma=false;
                }else if(line.contains("'") && !misma){
                 line="<span class = \"literal\">"+line+" "+"</span>";

                }else if(tokens.contains(line) && !misma){
                 line="<span class = \"reservada\">"+line+" "+"</span>";
                 
                }else if(!line.contains("&nbsp")){
                    line="<span>"+line+" "+"</span>";
                }
                htmlResult=htmlResult+line+" ";
                
            }
            htmlResult=htmlResult+"<br>";

        }

    
   
    
    
   public void createFile () throws FileNotFoundException, UnsupportedEncodingException{
       PrintWriter writer = new PrintWriter(removeExtension(fileName)+".html", "UTF-8");
        String encabezado = 
             "<style> span {font-family:'FreeMono', monospace; font-size: 1em;}\n"
             + ".reservada{font-weight: bold;}\n"
             + ".literal{color: darkblue;}\n"
             + ".identificador{color: black;}\n"
             + ".comentario{color: green;}\n"
             + "</style>";
       writer.print(encabezado);
       writer.print(htmlResult);
       writer.close();
   }
   
   public static ArrayList<String> divisorTokens(String ent){
        ArrayList<String> resultado = new ArrayList<String>();
        
        String temp = "";
        for(char i=0; i < ent.length() ;i++){
            if(ent.charAt(i)==' '){
                resultado.add(temp);
                temp="";
                resultado.add("&nbsp");
            }else
            if(ent.charAt(i)=='\t'){
                resultado.add(temp);
                temp="";
                resultado.add("&nbsp &nbsp &nbsp &nbsp");
            }
            else{
                temp+=ent.charAt(i);
            }
            
        }
        resultado.add(temp);
        
        return resultado;
    
    }
   
  private static boolean isNumber(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
}
    private static String removeExtension (String str) {
        if (str == null) return null;
            int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
            return str.substring(0, pos);
    }
     List<String> tokens = Arrays.asList(
    "array",
    "const",
    "do",
    "else",
    "end", 
    "for", //AGREGADA
    "from", //10  //AGREGADA
    "func",
    "if",
    "in",
    "let",
    "of",
    "package", //AGREGADA
    "private", //AGREGADA
    "proc",
    "rec", //AGREGADA
    "record", //20
    "repeat", //AGREGADA
    "select", //AGREGADA
    "skip", //AGREGADA
    "then",
    "times", //AGREGADA
    "type",
    "until", //AGREGADA
    "var",
    "when", //AGREGADA
    "while"//30
     );
}