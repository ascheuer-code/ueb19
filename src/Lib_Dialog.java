import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* In die Main einfügen
*
* classObject = new Main(); - (Main representiert die Klasse in der die Dialog Logik hinterlegt ist)
*
*/

public class Lib_Dialog {

    private int option = -1;
    public static Scanner input;
    private static int optioncounter;

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue, Object classObject) {

        input = new Scanner(System.in);
        final int ENDE = -5;

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption(menue);
                ausfuehrenFunktion(menue, option, classObject);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getCause());
            }
        }

    }

    /**
     * Methode zur Ausgabe eines Wahlmenues
     * 
     * @param arraylist Arrayliste anhand der das Menue erstellt wird
     */

    public static <T> void printMenue(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        optioncounter = 0;
        System.out.println("");
        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.println(sb);

    }

    /**
     * Methode für die Optionsanfrage des Menues
     * 
     * @return int Menuepunkt
     */

    public static int chooseOption(ArrayList<String> menue) {

        System.out.print("\nPlease choose a Option\n");
        int options = input.nextInt();

        Lib_Digits.checkSpan(1, menue.size(), options, "Option");
        return options;

    }

    /**
     * Methode zum ausführen der entsprechenden Logik die hinter dem Menuepunkt
     * liegt
     * 
     * @param option Optionsauswahl von chooseOption()
     */

    public static void ausfuehrenFunktion(ArrayList<String> menue, int option, Object classObject)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method method = classObject.getClass().getMethod(Lib_String.menueToMethod(menue.get(option - 1)));
        method.invoke(classObject);
    }

}
