import java.util.*;

public class daskaren {
        public static double k = 250;

        public static double Integral(double a, double b){
            int n = 1000;
            double deltax = (b-a)/n;
            double resultat = 0;


            for(int k = 0 ; k < n ; k++){
                resultat = f(a+k*deltax)*deltax;
            }


            return resultat;
        }

        public static double f(double x){
            double k = 250;
            return k*x;
        }

    public static void main(String[] args){
            Scanner in = ;
    }
}
