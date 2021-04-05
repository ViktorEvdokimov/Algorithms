public class Exponentiation {

    public static void main(String[] args) {
        testExponentiation();
    }

    private static void testExponentiation(){
        System.out.println(exponentiation(5,5));
        System.out.println(exponentiation(0,5));
        System.out.println(exponentiation(5,-2));
        System.out.println(exponentiation(-5,4));
        System.out.println(exponentiation(5,0));
    }

    private static float exponentiation(float value, int exponent){
        if (value==0) return 0;
        if (exponent==0) return 1;
        if (exponent>0) return value*exponentiation(value, exponent-1);
        return (1*exponentiation(value,exponent+1))/value;
    }
}
