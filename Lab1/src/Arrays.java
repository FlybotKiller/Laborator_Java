public class Arrays {
    public static void main(String[] args) {
        int[] month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie",
                "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"};
        int ctr = 0; //counter luni sub 31 de zile
        int sum = 0; //suma zilelor
        System.out.println("--Lunile impreuna cu nr. lor de zile:");
        for (int i = 0; i < month_days.length; i++) {
            System.out.println(months[i].substring(0, 3) + " " + month_days[i]);
            //se foloseste metoda ".substring(beginning,end)" pt afisarea a "n" caractere din String
            /*fara acea metoda s-ar afisa String-ul intreg, deci voi considera prima si ultima cerinta indeplinite
            pentru a economisi din cod*/
        }
        System.out.println("--Lunile care au 31 de zile sunt:");
        for (int i = 0; i < month_days.length; i++) {
            if (month_days[i] == 31)
                System.out.println(months[i]);
            //cerinta 2
        }
        System.out.println("--Lunile care au sub 31 de zile sunt:");
        for (int i = 0; i < month_days.length; i++) {
            if (month_days[i] < 31) {
                System.out.println(months[i]);
                ctr++;
                sum += month_days[i];
            }
        }
        System.out.println("--" + ctr + " luni au sub 31 de zile.");
        System.out.println("--Numarul total de zile al lunilor care au sub 31 de zile este: " + sum);
        //cerintele 3,4
    }
}