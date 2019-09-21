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

    public void algorithmAlt() {
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

    public static void main(String[] args) {
        
    }
}
