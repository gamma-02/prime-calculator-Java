import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static BigInteger factorial(BigInteger input){
        if(input.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }else{
            return factorial(input.subtract(BigInteger.ONE)).multiply(input);
        }
    }

    public static boolean isPrime(BigInteger input){
        return (factorial(input.subtract(BigInteger.ONE)).add(BigInteger.ONE).mod(input).equals(BigInteger.ZERO));
    }

    public static BigInteger nthPrime(int n){

        BigInteger prime = BigInteger.ONE;
        int primes = 0;

        while(true){


            BigInteger primett = prime;

            if(primett.equals(BigInteger.TWO)){
                prime = prime.add(BigInteger.ONE);
                primes++;
            }

            if(isPrime(primett)){
                primes++;
                if(primes == n){
                    return prime;
                }
            }

            if(prime.add(BigInteger.ONE).mod(BigInteger.TWO).equals(BigInteger.ZERO) && !prime.equals(BigInteger.TWO)){
                prime = prime.add(BigInteger.ONE);
            }

            prime = prime.add(BigInteger.ONE);
        }


    }


    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please input a whole number to calculate the nth prime or exit to exit: ");
            String input = "";
            if(sc.hasNextLine()){
                input = sc.nextLine();
            }
            if(input.contains("exit")){
                break;
            }
            int n = 0;
            try{
                n = Integer.parseInt(input);
            }catch (Exception e){
                System.out.println("NOT A VALID INT.");
                continue;
            }
            if(n <= 0){
                System.out.println("NOT A VALID INT.");
                continue;
            }

            System.out.println(n + (n <= 3 ? (n == 3 ? "rd":(n == 2? "nd" : "st")) : "th") + " prime: " + nthPrime(n));


        }
        System.out.println("Thank you for using!\nMade by gamma_02");
    }
}
