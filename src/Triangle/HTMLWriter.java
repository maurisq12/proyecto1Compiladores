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

    private String htmlResult = "";

    private String fileName;

    void ParseHtml(String sourceName) throws IOException {
        fileName = sourceName;
        ArrayList<String> ListaObjetos = new ArrayList<String>();
        File file = new File(sourceName);
        Scanner input = new Scanner(file);

        int count = 0;
        while (input.hasNextLine()) {
            String linea = input.nextLine();
            ArrayList<String> ListaTokens = divisorTokens(linea);
            for (String pol : ListaTokens) {
                ListaObjetos.add(pol);
            }
            ListaObjetos.add("\n");
        }
        Boolean lineaComentario = false;
        for (String objHtml : ListaObjetos) {
            if (isNumber(objHtml) && !lineaComentario) {
                objHtml = "<span class = \"literal\">" + objHtml + " " + "</span>";
            } else if (objHtml.contains("!")) {
                objHtml = "<span class = \"comentario\">" + objHtml;
                lineaComentario = true;
            } else if (objHtml == "\n") {
                objHtml = " " + "</span>";
                objHtml += "<br>";
                lineaComentario = false;
            } else if (objHtml.contains("'") && !lineaComentario) {
                objHtml = "<span class = \"literal\">" + objHtml + " " + "</span>";

            } else if (tokens.contains(objHtml) && !lineaComentario) {
                objHtml = "<span class = \"reservada\">" + objHtml + " " + "</span>";

            } else if (!objHtml.contains("&nbsp")) {
                objHtml = "<span>" + objHtml + " " + "</span>";
            }
            htmlResult = htmlResult + objHtml + " ";

        }
        htmlResult = htmlResult + "<br>";

    }

    public void createFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(removeExtension(fileName) + ".html", "UTF-8");
        String encabezado
                = "<style> span {font-family:'FreeMono', monospace; font-size: 1em;}\n"
                + ".reservada{font-weight: bold;}\n"
                + ".literal{color: darkblue;}\n"
                + ".comentario{color: green;}\n"
                + "</style>";
        writer.print(encabezado);
        writer.print(htmlResult);
        writer.close();
    }

    public static ArrayList<String> divisorTokens(String ent) {
        ArrayList<String> resultado = new ArrayList<String>();

        String temp = "";
        for (char i = 0; i < ent.length(); i++) {
            if (ent.charAt(i) == ' ') {
                resultado.add(temp);
                temp = "";
                resultado.add("&nbsp");
            } else if (ent.charAt(i) == '\t') {
                resultado.add(temp);
                temp = "";
                resultado.add("&nbsp &nbsp &nbsp &nbsp");
            } else {
                temp += ent.charAt(i);
            }

        }
        resultado.add(temp);

        return resultado;

    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        int pos = str.lastIndexOf(".");
        if (pos == -1) {
            return str;
        }
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
