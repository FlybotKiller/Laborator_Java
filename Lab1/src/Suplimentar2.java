import java.util.Arrays;
public class Suplimentar2 {
    public static void main(String[] args) {
       String[] arr = {"Now", "is", "the", "time", "for", "all", "good", "men", "to", "come", "to",
                "the", "aid", "of", "their", "country"};
        String[] arr2 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        //cerinta 1 ; afiseaza array-ul de string-uri sortat 
        System.out.println(" ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            //afiseaza array-ul de string-uri concatenat
        }
    }
}
