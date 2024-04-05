import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeerTxt {

    //Lee el archivo texto.txt y lo traduce al español
    public void readTxt(BinarySearchTree<String, Association<String, String, String>> englishTree) {
        String languageTo = "Spanish";
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            StringBuilder translatedText = new StringBuilder(); //concatena
    
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" "); //separa las palabras por cada espacio en blanco
    
                for (String word : words) {
                    String lowerCaseWord = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Eliminar caracteres no alfabéticos
                    Association<String, String, String> found = englishTree.find(lowerCaseWord); //Encuentra palabras en inglés
                    
                    if (found != null) {
                        String translatedWord = languageTo.equals("Spanish") ? found.getValue1() : found.getValue2(); //Cambia al español
                        
                        if (languageTo.equals("Spanish")) {
                            translatedWord = found.getValue1();
                        } else if (languageTo.equals("French")) { //Cambia al francés si lo detecta
                            translatedWord = found.getValue2();
                        } else if (languageTo.equals("English")) {
                            translatedWord = found.getKey();
                        }
    
                        translatedText.append(translatedWord).append(" "); //Une palabras traducidas con las que no están en el diccionario
                    } else {
                        translatedText.append("*").append(word).append("* ").append(" "); //Le pone asterisco a las palabras NO traducidas
                    }
                }
                // Agregar un espacio adicional después de cada línea
                translatedText.append("\n");
            }
            System.out.println(translatedText.toString());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    //Crea árbol binario de cada idioma
    public void creatTree(BinarySearchTree<String, Association<String, String, String>> english, BinarySearchTree<String, Association<String, String, String>> spanish, BinarySearchTree<String, Association<String, String, String>> french) {
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                Association<String, String, String> association = new Association<>(words[0], words[1], words[2]);
                english.insert(words[0].toLowerCase(), association);
                spanish.insert(words[1].toLowerCase(), association);
                french.insert(words[2].toLowerCase(), association);
            }
            System.out.println("árboles generados...");;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
