/*import java.util.Scanner;

public class Light {

  private boolean status = true; //on or off (1 or 0) //default on
  static Scanner sc = new Scanner(System.in);

  //default constructor
  Light () {
    System.out.println("Light x/5 is ON");
  }

  //custom constructor
  Light (int i) {
    System.out.println("Light " + i + " is ON");
  }

  //methods
  //sets lights to OFF
  public void lightsOut (int i) {
    status = !status;
    //System.out.printf("\nLight %d is %s", i,  status ? "ON" : "OFF");
  }

  public static void reactionTime () {
    System.out.println("\nIT'S LIGHTS OUT!");

    //measure reaction time
    long start = getTime();

    while (true) {
      String in = sc.nextLine();

      System.out.println(in);

      if (in.equalsIgnoreCase(" ")) {
        long fin = getTime();

        long milliTime = (fin - start) / 1000000; // milliseconds

        System.out.println(milliTime);
        break;

      } else {
        System.out.println("Time Error");
        break;
      }
    }

    sc.close();

  }

  public static long getTime () {
    return System.nanoTime();
  }

}

*/

public class Light {
  private boolean status = true; // On or off (true = ON, false = OFF)

  // Default constructor
  public Light() {
    System.out.println("\nLight x/5 is ON");
  }

  // Custom constructor
  public Light(int i) {
    System.out.println("Light " + i + " is ON");
  }

  // Sets light to OFF
  public void lightsOut(int i) {
    status = !status;
    //System.out.printf("Light %d is %s\n", i, status ? "ON" : "OFF");
  }

  public static void reactionTime() {
    System.out.println("\nThanks for trying this out <3 \nClose the window to exit code. \n~V :3");
  }

  public static long getTime() {
    return System.nanoTime();
  }
}
