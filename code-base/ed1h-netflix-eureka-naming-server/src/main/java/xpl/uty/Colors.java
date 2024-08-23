package xpl.uty;
public class Colors {
   // #region colors
   // Reset
   public static final String RESET = "\033[0m"; // Text Reset
   // Regular Colors
   public static final String GREEN = "\033[0;32m"; // GREEN
   public static final String YELLOW = "\033[0;33m"; // YELLOW
   // High Intensity
   public static final String RED_BRIGHT = "\033[0;91m"; // RED
   public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
   public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
   public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
   // Underline
   public static final String RED_BRIGHT_UNDERLINED = "\033[4;91m"; // RED
   public static final String GREEN_UNDERLINED = "\033[4;32m"; // GREEN
   public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
   public static final String BLUE_BRIGHT_UNDERLINED = "\033[4;94m"; // BLUE
   public static final String PURPLE_BRIGHT_UNDERLINED = "\033[4;95m"; // PURPLE
   public static final String CYAN_BRIGHT_UNDERLINED = "\033[4;96m"; // CYAN

   // #endregion colors
   public static void printMessageWithClassAndMethodName(Object message) {
      String classAndMethodName = Thread.currentThread().getStackTrace()[3].getClassName() + "." +
              Thread.currentThread().getStackTrace()[3].getMethodName() + "@" +
              Thread.currentThread().getStackTrace()[3].getLineNumber();
      System.out.println(message + " => " + classAndMethodName + RESET);
   }
   // obsolete method
   // public static void ppu(Object message) {
   //    System.out.println(PURPLE_BRIGHT_UNDERLINED + message + RESET);
   // }

   public static void pp(Object message) {
      printMessageWithClassAndMethodName(PURPLE_BRIGHT + message);
   }

   public static void ppu(Object message) {
      printMessageWithClassAndMethodName(PURPLE_BRIGHT_UNDERLINED + message);
   }

   public static void pb(Object message) {
      printMessageWithClassAndMethodName(BLUE_BRIGHT + message);
   }

   public static void pbu(Object message) {
      printMessageWithClassAndMethodName(BLUE_BRIGHT_UNDERLINED + message);
   }

   public static void pc(Object message) {
      printMessageWithClassAndMethodName(CYAN_BRIGHT + message);
   }

   public static void pcu(Object message) {
      printMessageWithClassAndMethodName(CYAN_BRIGHT_UNDERLINED + message);
   }

   public static void pg(Object message) {
      printMessageWithClassAndMethodName(GREEN + message);
   }

   public static void pgu(Object message) {
      printMessageWithClassAndMethodName(GREEN + message);
   }

   public static void pr(Object message) {
      printMessageWithClassAndMethodName(RED_BRIGHT + message);
   }

   public static void pru(Object message) {
      printMessageWithClassAndMethodName(RED_BRIGHT_UNDERLINED + message);
   }

   public static void py(Object message) {
      printMessageWithClassAndMethodName(YELLOW + message);
   }

   public static void pyu(Object message) {
      printMessageWithClassAndMethodName(YELLOW_UNDERLINED + message);
   }
}
