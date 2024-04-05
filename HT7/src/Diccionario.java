import java.util.Comparator;
import java.util.Scanner;

public class Diccionario {

    String archivoDiciconario = "diccionario.txt";
    String archivoTexto = "texto.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean salir = false;

        Comparator<String> comparator = Comparator.naturalOrder();
        BinarySearchTree<String, Association<String, String, String>> spanish = new BinarySearchTree<String, Association<String, String, String>>(comparator);
        BinarySearchTree<String, Association<String, String, String>> french = new BinarySearchTree<String, Association<String, String, String>>(comparator);
        BinarySearchTree<String, Association<String, String, String>> english = new BinarySearchTree<String, Association<String, String, String>>(comparator);

        LeerTxt arbol = new LeerTxt();
        arbol.creatTree(english, spanish, french);

        while (!salir) {
            System.out.println("\n<<TRADUCTOR INGLÉS-ESPAÑOL-FRANCÉS>>: ");
            System.out.println("\nMenú: \n1.Traducir texto \n2.Ordenar Inglés \n3.Ordenar Español \n4.Ordenar Francés \n5.Salir");
            String traduccion = sc.nextLine();

            switch (traduccion) {
                case "1":
                    System.out.println("\nÁRBOL");
                    LeerTxt lt = new LeerTxt();
                    lt.readTxt(english);
                    break;
                case "2":
                    System.out.println("\nINGLÉS");
                    palabrasOrdenadas(english);
                    break;
                case "3":
                    System.out.println("\nESPAÑOL");
                    palabrasOrdenadas(spanish);
                    break;
                case "4":
                    System.out.println("\nFRANCÉS");
                    palabrasOrdenadas(french);
                    break;
                case "5":
                    System.out.println("\nSALIR");
                    salir = true;
                    break;
                default:
                    System.out.println("OPCIÓN NO VALIDA.\nPor favor ingrese una opción válida.");
            }
        }
        sc.close();
    }

    private static void palabrasOrdenadas(BinarySearchTree<String, Association<String, String, String>> tree) {
        IWalk<Association<String, String, String>> printWalk = association -> {
            System.out.println(
                    "(" + association.getKey() + ", " + association.getValue1() + ", " + association.getValue2() + ")");
        };
        tree.InOrderWalk(printWalk);
    }
}
