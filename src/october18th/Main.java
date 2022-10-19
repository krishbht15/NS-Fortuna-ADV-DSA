package october18th;

public class Main {
    public static void main(String[] args) {
        printIncDec(5);
    }

    public static void printIncreasing(int n){
        if(n==0)return;
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if(n==0)return;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncDec(int n){
        if(n==0) return;
        System.out.println("Decreasing - "+n);
        printIncDec(n-1);
        System.out.println("Increasing - "+n);
    }
}