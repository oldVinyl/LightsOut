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
