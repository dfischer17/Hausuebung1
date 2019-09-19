public class EratosthenesPrimeSieve implements PrimeSieve{

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

    }

    public static void main(String[] args) {
        
    }
}
