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

   public static void pp(Object message) {
      System.out.println(PURPLE_BRIGHT + message + RESET);
   }

   public static void ppu(Object message) {
      System.out.println(PURPLE_BRIGHT_UNDERLINED + message + RESET);
   }

   public static void pb(Object message) {
      System.out.println(BLUE_BRIGHT + message + RESET);
   }

   public static void pbu(Object message) {
      System.out.println(BLUE_BRIGHT_UNDERLINED + message + RESET);
   }

   public static void pc(Object message) {
      System.out.println(CYAN_BRIGHT + message + RESET);
   }

   public static void pcu(Object message) {
      System.out.println(CYAN_BRIGHT_UNDERLINED + message + RESET);
   }

   public static void pg(Object message) {
      System.out.println(GREEN + message + RESET);
   }

   public static void pgu(Object message) {
      System.out.println(GREEN + message + RESET);
   }

   public static void pr(Object message) {
      System.out.println(RED_BRIGHT + message + RESET);
   }

   public static void pru(Object message) {
      System.out.println(RED_BRIGHT_UNDERLINED + message + RESET);
   }

   public static void py(Object message) {
      System.out.println(YELLOW + message + RESET);
   }

   public static void pyu(Object message) {
      System.out.println(YELLOW_UNDERLINED + message + RESET);
   }
}
