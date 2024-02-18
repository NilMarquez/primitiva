import java.util.Scanner;
import java.util.Random;
/**
 * Programa de simulació de La Primitiva
 * @auhor Nil Marquez & Roger Bustos
 * Link github: https://github.com/NilMarquez/primitiva
 * @version 1.0
 * @date 16/02/2024
 */
<<<<<<< HEAD
=======
//TODO: Fer refractor per canviar el nom de la classe
>>>>>>> roger

public class Main {
    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Aquest mètode representa el menú principal.
     * Permet a l'usuari seleccionar entre dues opcions: jugar o sortir.
     * Si l'usuari selecciona jugar, es crida al mètode jugar().
     * @since 1.0
     */
    private static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);

        int opcio;
        do {
            System.out.println("***** PRIMITIVA ******");
            System.out.println("1. Jugar");
            System.out.println("2. Sortir");
            System.out.print("Selecciona una opció: ");

            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    jugar();
                    break;
                case 2:
                    System.out.println("Sortint del programa, Adeu!");
                    break;
                default:
<<<<<<< HEAD
                    System.out.println(" no valida. Intenta-ho de nou");
=======
                    System.out.println("Opció no valida. Intenta-ho de nou");
>>>>>>> roger
            }

        } while (opcio != 2);
    }

    /**
     * En aquest mètode l'usuari pot introduir una aposta que calcula la combinació guanyadora.
     * Es mostra aquesta combinació i imprimeix per pantalla el premi i els encerts de l'usuari.
     * @since 1.0
     */
    private static void jugar() {
        int[] aposta = introduirAposta();
        int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
        int premi;

        if (combinacioGuanyadora != null) {
            System.out.println("La combinació guayadora és: ");

            for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                System.out.print(combinacioGuanyadora[i] + " ");
            }

            System.out.println("Reintegre " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
        }

        premi = comprovarEncerts(aposta, combinacioGuanyadora);
        System.out.println("El teu premi és: " + premi + " €");
    }
    /**
<<<<<<< HEAD
     * //Serveix per a guardar els paràmetres introduits per l'usuari per a endevinar
=======
     * Serveix per a guardar els paràmetres introduits per l'usuari per a endevinar
>>>>>>> roger
     * @return Aquest return guarda les dades introduïdes per l'usuari al mètode d'introduitAposta,
     * i les fa servir en el següents mètodes per calcular la combinació i comprobar encerts.
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];
        boolean[] numerosUsats = new boolean[50];
        int reintegrament;
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD

=======
>>>>>>> roger
        System.out.println("Introdueix 6 números entre 1 y 49 (sense repetir):");
        for (int i = 0; i < 6; i++) {
            int numero;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                if (numero < 1 || numero > 49 || numerosUsats[numero - 1]) {
                    System.out.println("Número invalid o repetit, intenta-ho de nou");
                }
            } while (numero < 1 || numero > 49 || numerosUsats[numero - 1]);
            aposta[i] = numero;
            numerosUsats[numero - 1] = true;
        }
<<<<<<< HEAD

=======
>>>>>>> roger
        System.out.println("Introdueix un número entre el 0 i 9 per reintegre");
        do {
            System.out.print("Reintegre: ");
            reintegrament = scanner.nextInt();
            if (reintegrament < 0 || reintegrament > 9) {
                System.out.println("Número inválido. Inténtalo de nuevo.");
            }
        } while (reintegrament < 0 || reintegrament > 9);
        aposta[6] = reintegrament;
<<<<<<< HEAD

=======
>>>>>>> roger
        return aposta;
    }

    /**
<<<<<<< HEAD
     * //Genera la combinació guanyadora de la primitiva
=======
     * Genera la combinació guanyadora de la primitiva
>>>>>>> roger
     * @return Retorna la combinació guanyadora i el seu reintegrament
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = new int [7];
        //TODO: Fer el codi del mètode
        Random random = new Random();
        combinacio[0] = random.nextInt((49 + 1) - 1) + 1;
        for (int i=1; i<6; i++) {
            boolean diff=false;
            do {
                combinacio[i] = random.nextInt((49 + 1) - 1) + 1;
                for (int j=0; j<i; j++){
                    if (combinacio[j]==combinacio[i]){
                        break;
                    } else if (j==i-1 && combinacio[j]!=combinacio[i]){
                        diff=true;
                        break;
                    }
                }
            }while(!diff);
        }
        combinacio[6] = random.nextInt((10));
        return combinacio;
    }

    /**
<<<<<<< HEAD
     * //Calcula el premi final que s'endú l'usuari
     * @param aposta  aposta que ha generat o fet l'usuari
     * @param combinacioGuanyadora La combinació que conté el premi
     * @return  el premi total que s'endú el guanyador
=======
     * Calcula el premi final que s'endú l'usuari
     * @param aposta Completar //aposta que ha generat o fet l'usuari
     * @param combinacioGuanyadora Completar// La combinació que conté el premi
     * @return Completar el premi total que s'endú el guanyador
>>>>>>> roger
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
<<<<<<< HEAD
=======
        //TODO: Fer el codi del mètode
>>>>>>> roger
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (aposta[i]==combinacioGuanyadora[j]){
                    encerts++;
                    break;
                }
            }
        }

        //Comprobar reintegrament
<<<<<<< HEAD
=======
        //TODO: Fer el codi del mètode
>>>>>>> roger
        if (aposta[6]==combinacioGuanyadora[6]){
            reintregrament=true;
        }

        //Calcular premi

        premi=premi+(encerts*20);
        if (reintregrament){
            premi=premi+6;
        }

        premi=premi+(encerts*20);
        if (reintregrament){
            premi=premi+6;
        }
        return premi;
    }
    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);
        return x;
    }
    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner llegir = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.print(missatge);
            valorCorrecte = llegir.hasNextFloat();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = llegir.nextFloat();
            }
            llegir.nextLine();
        }while(!valorCorrecte);
        return x;
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> roger
