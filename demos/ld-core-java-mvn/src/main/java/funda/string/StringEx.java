package funda.string;

public class StringEx {
    public static void main(String[] args) {
        //constant, once assigned
        // declaration & initialization
        final String companyName = "Ascendion";
        //cannot reassign value
//        companyName = "AscendioN";
        final String companyLogo;
        companyLogo = "A";
//        companyLogo = "AA";
        // variable vs constants vs immutability
        String location = "Chennai";
        location = "Mumbai";
        String str = "A";
        for(int i = 0 ;i<10;i++){
            str+= i;
        }
        System.out.println(str);

        String s1 = "Hello";
        String s2 = "Hello";
        if(s1.equals(s2)){
            System.out.println("1EQUAL");
        }
        if(s1 == s2){
            System.out.println("1IDENTICAL");
        }
        s2 = new String("Helo");
        if(s1.equals(s2)){
            System.out.println("2EQUAL");
        }
        if(s1 == s2){
            System.out.println("2IDENTICAL");
        }
        String s3 = "Helo";
         s1 = s3;
         s2 = s1;

        if((s1.equals(s2) && s2.equals(s3) && s1.equals(s3)) && (s1 == s2 && s2 == s3 && s1 == s3)){
            System.out.println("All are EQUAL and IDENTICAL");
        }

    }


}
