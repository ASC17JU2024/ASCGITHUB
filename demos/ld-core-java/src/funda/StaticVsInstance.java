package funda;

public class StaticVsInstance {
    public static void main(String[] args) {
        System.out.println("StaticVsInstance");
        FamilyMember.toothPaste = "Colgate";
        FamilyMember.displayFamilyMemberDetails();
        System.out.println(FamilyMember.toothPaste);
//        System.out.println(FamilyMember.toothBrush);
//        FamilyMember.displayIndividualFamilyMemberDetails();
        FamilyMember rajinikanth = new FamilyMember();
        rajinikanth.toothBrush = "Oral-B";
        rajinikanth.displayIndividualFamilyMemberDetails();
        FamilyMember vijaykanth = new FamilyMember();
        vijaykanth.toothBrush = "Patanjali";
        vijaykanth.displayIndividualFamilyMemberDetails();
    }
}

class FamilyMember{
    String toothBrush;
    static String toothPaste;

    public static void displayFamilyMemberDetails(){
//        System.out.println(toothBrush);
        System.out.println(toothPaste);
    }
    public void displayIndividualFamilyMemberDetails(){
        System.out.println(toothBrush);
        System.out.println(toothPaste);
    }
}
