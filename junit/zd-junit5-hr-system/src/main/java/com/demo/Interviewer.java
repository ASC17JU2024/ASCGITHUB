package com.demo;
//  An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
/**
 * The Interviewer enum represents a group of constants, where each constant is a candidate with a name.
 * Each constant is an instance of the Interviewer enum and calls the enum constructor with a string argument,
 * which represents the name associated with the candidate.
 */
public enum Interviewer {
   // abeBee("Abe Bee"),
   // calDee("Cal Dee"),
   // eliFey("Eli Fey"),
   // gusHee("Gus Hee"),
   // ivyJay("Ivy Jay"),
   // kenLee("Ken Lee"),
   // myaNee("Mya Nee"),
   // oraPay("Ora Pay"),
   // raySee("Ray See"),
   // timVee("Tim Vee"),
   // ulyWee("Uly Wee"),
   // valXee("Val Xee"),
   // zoeZee("Zoe Zee");


      BEE("Abe Bee"),
      DEE("Cal Dee"),
      FEY("Eli Fey"),
      HEE("Gus Hee"),
      JAY("Ivy Jay"),
      LEE("Ken Lee"),
      NEE("Mya Nee"),
      PAY("Ora Pay"),
      SEE("Ray See"),
      VEE("Tim Vee"),
      WEE("Uly Wee"),
      XEE("Val Xee"),
      ZEE("Zoe Zee");
   // Each enum constant has its own copy of this variable.
   private String name;

   /**
    * The constructor of the enum. It's called separately for each enum constant at the time the constant is created.
    * The constructor takes a string argument and assigns it to the name instance variable.
    * Enum constructors are always private. If you don't declare it as private, the compiler will do so implicitly.
    */
   Interviewer(String name) {
      this.name = name;
   }

   /**
    * This is a public method that returns the name associated with the enum constant.
    * Since the name variable is private, this "getter" method is needed to access the name outside of the enum.
    */
   public String getName() {
      return name;
   }
}