package CSE260;

public class Primes {
	public static void main(String[] args) {
        
        int[] prime = {1000, 10000, 100000};
        
        for(int k = 0; k < prime.length; k++) {
            long startTime = System.currentTimeMillis();
            for(int i = 1; i <= prime[k]; i++) {
                isPrime(i);
            }
            System.out.println("Time for " + prime + ": " + (System.currentTimeMillis() - startTime));
            
        }
    }
    
    public static boolean isPrime(int n) {
        if(n == 1 || n == 0)
            return false;
        
        for(int i = 2; i < n; i++) {
            if(n % i==0)
                return false;
        }
        
        return true;
    }


}
