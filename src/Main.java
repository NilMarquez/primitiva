import java.util.Scanner;
import java.util.Random;
/**
 * Programa de simulació de La Primitiva
 * @auhor Nil Marquez & Roger Bustos
 * @version 1.0
 * @date 16/02/2024
 */
//TODO: Fer refractor per canviar el nom de la classe
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
     * //TODO: Completar
     * @since 1.0
     */
    private static void menuPrincipal(){
        System.out.println("***** PRIMITIVA ******");

        int[] aposta = introduirAposta();
        int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
        int premi;

        if (combinacioGuanyadora != null) {
            System.out.println("La combinació ganadora és: ");

            for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                System.out.print(combinacioGuanyadora[i] + " ");
            }

            System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
        }

        premi = comprovarEncerts(aposta, combinacioGuanyadora);
        System.out.println("El teu premi és: "+premi+" €");
    }

    /**
     * //Serveix per a guardar els paràmetres introduits per l'usuari per a endevinar
     * @return //TODO: Aquest return guarda les dades introduïdes per l'usuari al mètode d'introduitAposta,
     * i les fa servir en el següents mètodes per calcular la combinació i comprobar encerts.
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];
        boolean[] numerosUsats = new boolean[50];
        int reintegrament;
        Scanner scanner = new Scanner(System.in);

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

        System.out.println("Introdueix un número entre el 0 i 9 per reintegre");
        do {
            System.out.print("Reintegre: ");
            reintegrament = scanner.nextInt();
            if (reintegrament < 0 || reintegrament > 9) {
                System.out.println("Número inválido. Inténtalo de nuevo.");
            }
        } while (reintegrament < 0 || reintegrament > 9);
        aposta[6] = reintegrament;

        return aposta;
    }

    /**
     * //Genera la combinació guanyadora de la primitiva
     * @return //TODO: Retorna la combinació guanyadora i el seu reintegrament
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
     * //Calcula el premi final que s'endú l'usuari
     * @param aposta //TODO: Completar //aposta que ha generat o fet l'usuari
     * @param combinacioGuanyadora //TODO: Completar// La combinació que conté el premi
     * @return //TODO: Completar el premi total que s'endú el guanyador
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        //TODO: Fer el codi del mètode
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (aposta[i]==combinacioGuanyadora[j]){
                    encerts++;
                    break;
                }
            }
        }

        //Comprobar reintegrament
        //TODO: Fer el codi del mètode
        if (aposta[6]==combinacioGuanyadora[6]){
            reintregrament=true;
        }

        //Calcular premi
        //TODO: Fer el codi del mètode

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
     * @param max valor max acceptat
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

}
