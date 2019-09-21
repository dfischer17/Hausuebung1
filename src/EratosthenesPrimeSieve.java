import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve{
    private int p;

    public EratosthenesPrimeSieve(int p) {
        this.p = p;
    }

    @Override
    public boolean isPrime(int p) {
        if (p < 2) {
            return false;
        }
        else {
            for (int i = 2; i < p; i++) {
                if (p % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        for (int k = 0; k < p; k++) {
            if (isPrime(k)) {
                System.out.println(k);
            }
        }
    }

    // Aufgabe1
    public void algorithm() {
        boolean[] arr = new boolean[p + 1];

        // Potenzielle Primzahlenliste durchlaufen
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                System.out.println(i);
                // Alle Vielfachen einer Primzahl markieren
                for (int j = 1; i * j <= p; j++) {
                    arr[i * j] = true;
                }
            }
        }
    }

    // Aufgabe2
    public void algorithm2() {
        /*
        Wir wissen, N sind alle natürlichen Zahlen. Wir denieren nun die Menge Ng als die Menge aller
        geraden natürlichen Zahlen. Weiters sei P die Menge aller Primzahlen. Es gibt nun eine Vermutung
        die besagt: Für jede Zahl n ∈ Ng, wobei n > 2 gilt, gibt es zwei Zahlen x, y ∈ P sodass gilt: n = x+y.
        Beispiele sind: 5 + 13 = 18, 2 + 2 = 4, 3 + 3 = 6
        Man kann leicht einsehen, dass die Summe nicht eindeutig sein muss: 7 + 11 = 5 + 13 = 18.
        */

        /*
        Implementieren Sie einen Algorithmus, welcher für jede gerade natürliche Zahl n > 2 bis zu einer
        Obergrenze o ∈ N zwei Primzahlen x, y ∈ P ndet, sodass gilt: x + y = n. Verwenden Sie dazu die
        Klasse EratosthenesPrimeSieve
        */
        List<Integer> primeNumbers = new ArrayList<>();
        // zwei Primzahlen addieren welche eine gerade Zahl < 2 ergeben

            // Alle Primzahlen bis Obergrenze herausfinden
            for (int i = 2; i <= p; i++) {
                if (isPrime(i)) {
                    primeNumbers.add(i);
                }
            }

            // x + y Werte herausfinden
            for (int i = 0; i < ; i++) {
                
            }
    }

    public static void main(String[] args) {

    }
}
