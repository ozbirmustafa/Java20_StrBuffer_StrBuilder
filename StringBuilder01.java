package day20stringbuilderstringbuffer;

public class StringBuilder01 {
    /*
       1) "StringBuilder" bir Class'tır.
       2) "StringBuilder", String oluşturmaya yarar.
       3) "String" Class varken niçin "StringBuilder" a ihtiyaç duyarız.
           Çünkü "String" Class "Immutable Class"tır. Biz bazen "Mutable String" lere ihtiyaç duyarız.
          "StringBuilder" bize "Mutable String" verir.
       4) "Immutable Class" larda var olan değer değiştirilemez. Siz varolan bir değeri değiştirmek istediğinizde
           i) Memory'de yeni variable yeni bir değerle oluşturulur.
          ii) Eski variable in pointer i yeni variable a döndürülür.
         iii) Eğer variable i hiçbir pointer göstermiyorsa o variable "garbage collector" tarafından silinir.

          "Mutable Class" larda var olan değer değiştirilebilir. Orijinal değer korunmaz.

       5) "String Class"ların "immutable" yapisi "security" için önemlidir.
           Ayni değere sahip birden fazla String olduğunda, Java bir tabe container oluşturur ve aynı değere sahip Stringlerin
           bu container ı kullanmasını temin eder. Bu memory i korumak için iyidir ancak container'daki değeri bir variable için
           değiştirdiğimzde tüm variable ların etkilenmesi tehlikesi vardır. Bu tehlikeden kurtulmak için Java Stringleri "immutable" yapmıştır.
           Fakart herhangi bir variable in değerini değiştirmek için Java bir yol bulmuştur. Değiştirmek için yeni bir container oluşturur ve
           variable in pointer ini bu yeni variable a yönlendirir. Böylece hem değişim sağlanmış hem de diğerleri etkilenmemiş olur.
    */
    public static void main(String[] args) {

        String str = "Java";

        //StringBuilder nasıl oluşturulur?
        StringBuilder strb1 = new StringBuilder("Java");
        System.out.println(strb1);

        //2.Yol:
        StringBuilder strb2 = new StringBuilder();
        strb2.append("Java");
        strb2.append(" is Easy");
        strb2.append("!!");
        System.out.println(strb2); //Java is Easy!!

        //Yol.b

        strb2.append(" Learn").append(" Java Earn").append(" money.");
        System.out.println(strb2); //Java is Easy!! Learn Java Earn money.

        //StringBuilder'da karakter sayisi nasıl bulunur.

        StringBuilder strb3 = new StringBuilder();
        strb3.append("Cat");
        strb3.append("xxxxxxxxxxxxxxx");
        int numOfChar = strb3.length();
        System.out.println(numOfChar); //3 ==> //18

        int capacity = strb3.capacity();
        System.out.println(capacity); //16 ==> //34

        //capasity aşımlarında 2 katının 2 fazlası gelir. 16 karakterden fazla olursa capasity 34 olur. 34*2+2=70

        //SetchartAt(2, 'r') ==> index 2deki karakteri r ye çevir.

        System.out.println(strb3); //Catxxxxxxxxxxxxxxx

        strb3.setCharAt(2,'r');
        System.out.println(strb3); //Carxxxxxxxxxxxxxxx

        strb3.delete(3,18);
        System.out.println(strb3);

        strb3.deleteCharAt(2);
        System.out.println(strb3); //Ca

        strb3.reverse();
        System.out.println(strb3); //aC

        String abc = "Java";
        abc.replace("a","i");
        System.out.println(abc); //Java

        /*
            ***  Stringlerde(immutable) sadece method kullanarak değişim yapamayız. Atama yapmadan değişim olmaz       ***
            ***  StringBuilder'de(mutable) orijinal değeri değiştirmek için method yeterlidir. Atama yapmaya gerek yok ***
        */

        //StringBuilder ları String e çevirir.
        String stringStrb3 = strb3.toString();
        System.out.println(stringStrb3);

        StringBuilder strb4 = new StringBuilder(stringStrb3);
        strb4.append("mmmmmm");
        System.out.println(strb4); //aCmmmmmm

        strb4.insert(3,"XXX"); //3. karakterden sonra XXX leri koyar.
        System.out.println(strb4); //aCmXXXmmmmm

        strb4.insert(3,"KlMNOPQRSTUV",5,8);
        //3. karakterden sonra  "KlMNOPQRSTUV" String'inin  index 5,6,7 deki character leri yerleştiririz.
        System.out.println(strb4); //aCmPQRXXXmmmmm

        StringBuilder a = new StringBuilder("Java");
        StringBuilder b = new StringBuilder("Java");

        //a.compareTo(b) methodu i) StringBuilder lar aynıysa 0 verir.
        //                      ii) a alfabetik sıralamada b den sonra gelirse pozitif olarak aradaki alfabetik sıralama farkını gösterir.
        //                     iii) a alfabetik sıralamada b den önce gelirse negatif olarak aradaki alfabetik sıralama farkını gösterir.
        int sonuc = a.compareTo(b);
        System.out.println(sonuc);









    }
}
