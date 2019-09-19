import java.util.HashMap;
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

    public void algorithm() {
        // Liste der Potenziellen Primzahlen erstellen
        Map<Integer, Boolean> primeNumbersList = new HashMap<>();
        for (int i = 1; i <= p; i++) {
            primeNumbersList.put(i, false);
        }

        //wenn Primzahl gefunden ==> alle Vielfache markieren
        for (int i = 1; i <= p; i++) {
            if (isPrime(i)) {
                for (int k = 1; k < p; k++) {
                    primeNumbersList.put(i*k, true);
                }
            }
        }
    }

    public static void main(String[] args) {
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve(10);
        e.algorithm();
    }
}
