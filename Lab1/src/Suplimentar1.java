public class Suplimentar1 {
    public static void main(String[] args) {
        int[] sir1 = {12, 54, 2, 78, 36, 22, 92};
        int[] sir2 = {33, 6, 19, 86, 54, 44, 20, 78};
        int ctr = 0; //counter
        for (int i = 0; i < sir2.length; i++) {
            for (int j = 0; j < sir1.length; j++) {
                if (sir1[j] == sir2[i])
                    ctr++;
            }
        }
        System.out.println("Nr. elemente comune: " + ctr);
        //cerinta 1, in cazul in care sir1 e mai mare decat sir 2, vor trebui schimbate length-urile din for-uri

        int[] arr = {23,56,79, 61,34,61,79,56,23};
        boolean p = true;
        for (int i = 0; i < (arr.length - arr.length % 2) / 2; i++) {
            /*parcurge sirul pana la jumatate, daca lungimea pana la jumatate este impara
            arr.length % 2 = 1 iar indexul de mijloc va fi rotunjit, daca este par,
            arr.length % 2 = 0 iar indexul din mijloc va lua direct valoarea calculata */
            if (arr[i] != arr[arr.length - 1 - i]) {
                p = false;
                break;
                /* verifica daca valoarea din prima jumatate a sirului este diferita fata de
                valoarea din cealalta jumatate a sirului */
            }
        }
        if (p) {
            System.out.println("Sirul este palindrom.");
        } else {
            System.out.println("Sirul nu este palindrom.");
        }
        //cerinta 2
    }
}

