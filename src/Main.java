import java.util.Scanner;
import java.util.Random;
/**
 * Programa de simulació de La Primitiva
 * @auhor //TODO: Nom Alumne
 * @version 1.0
 * @date //TODO: data
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
     * //TODO: Completasr
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = null;

        //TODO: Fer el codi del mètode

        return aposta;
    }

    /**
     * //TODO: Genera la combinació guanyadora i el seu reintegrament sense repetir-hi cap numeró
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
     * //TODO: Completar
     * @param aposta //TODO: Completar
     * @param combinacioGuanyadora //TODO: Completar
     * @return //TODO: Completar
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