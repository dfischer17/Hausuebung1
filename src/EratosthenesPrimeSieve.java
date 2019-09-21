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
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve(20);
        e.algorithm2(4);
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
    public void algorithm2(int n) {
        if (n == p) {
            System.out.println("Ende");
            return;
        }

        List<Integer> primeNumbers = new ArrayList<>();
        // Alle Primzahlen bis Obergrenze herausfinden
        for (int i = 2; i <= p; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        
        // x-Werte durchlaufen
        for (int x = 0; x < primeNumbers.size(); x++) {

            // y-Werte durchlaufen
            for (int y = 0; y < primeNumbers.size(); y++) {
                if (primeNumbers.get(x) + primeNumbers.get(y) == n) {
                    System.out.println(primeNumbers.get(x) + " + " + primeNumbers.get(y) + " = " + n);
                }
            }
        }
        algorithm2(n + 2);
    }
}
