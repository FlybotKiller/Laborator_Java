public class Vars {
    public static void main(String[] args) {
        int x = 150;
        double y = 2.0;
        float z = 20f;
        byte b = 10;
        short c = 14;
        y = x;
        System.out.println(y); //output: 150.0
      /*  z = y;
        System.out.println(z); //output: error */
        Double l = 4.5654445;
        System.out.println(l);
        System.out.println(l.intValue()); // output: 4
        System.out.println(l.byteValue()); // output: 4
        System.out.println(l.parseDouble("2")); // output: 2.0
        int p = Integer.valueOf(2);
        System.out.println(p); // output: 2
        System.out.println(l.isNaN()); // output: false
    }
}
