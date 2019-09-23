import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EratosthenesPrimeSieve implements PrimeSieve {
    private int p;

    public EratosthenesPrimeSieve(int p) {
        this.p = p;
    }

    public static void main(String[] args) {
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve(100);
        System.out.println("Algorithmus 1");
        e.algorithm();
        System.out.println("Algorithmus 2");
        e.algorithm2(100);
    }

    @Override
    public boolean isPrime(int p) {
        if (p < 2) {
            return false;
        } else {
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
    public void algorithm2(int obergrenze) {
        boolean foundCombo = false;

        List<Integer> primeNumbers = new ArrayList<>();

        // Alle Primzahlen bis Obergrenze herausfinden
        for (int i = 2; i <= p; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        // Ganze Zahlen groesser als 2 durchlaufen
        for (int n = 0; n <= obergrenze; n += 2) {
            compare:

            // x-Werte durchlaufen
            for (int x = 0; x < primeNumbers.size(); x++) {

                // y-Werte durchlaufen
                for (int y = 0; y < primeNumbers.size(); y++) {
                    if (primeNumbers.get(x) + primeNumbers.get(y) == n) {
                        System.out.println(n + " " + "summe:" + " " + primeNumbers.get(x) + " + " + primeNumbers.get(y)
                                + " = " + n);
                        break compare;
                    }
                }
            }
        }

    }

    // Diese Rekursive Implementation wurde im Laufe der Entwicklung verworfen
    @Deprecated
    public void algorithm2Recursive(int n) {
        boolean foundCombo = false;

        List<Integer> primeNumbers = new ArrayList<>();

        // Alle Primzahlen bis Obergrenze herausfinden
        for (int i = 2; i <= p; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        // x-Werte durchlaufen
        for (int x = 0; x < primeNumbers.size(); x++) {
            if (foundCombo) {
                break;
            }

            // y-Werte durchlaufen
            for (int y = 0; y < primeNumbers.size(); y++) {
                if (primeNumbers.get(x) + primeNumbers.get(y) == n) {
                    System.out.println(
                            n + " " + "summe:" + " " + primeNumbers.get(x) + " + " + primeNumbers.get(y) + " = " + n);
                    foundCombo = true;
                }
            }
        }

        // Wenn alle Kombos bis zur gewünschten Zahl gefunden wurden beenden
        if (n == p) {
            return;
        }

        algorithm2Recursive(n + 2);
    }
}
