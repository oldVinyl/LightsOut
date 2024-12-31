/*import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
  public static void main (String[] args) {

    //timer delays
    int min = 500;
    int max = 3750;
    int w = max - min;

    int ONdelay = 1300;
    int OFFdelay = (int)(min + (Math.random() * w)); // 0.5 to 3.75s

    //initialize arrayList of Lights
    ArrayList<Light> lights = new ArrayList<Light>();

    //create lights - 5
    for (int i = 0; i < 5; i++) {
      lights.add(new Light(i + 1));
      //delay - 1300ms
      try {
        Thread.sleep(ONdelay);
      } catch (InterruptedException e) {
        System.out.println("delay error: " + e);
        break;
      }
    }

    //lights out
    for (int i = 0; i < 5; i++) {
      lights.get(i).lightsOut(i + 1);
    }

    //random delay
    try {
      Thread.sleep(OFFdelay);

      //measure, output reaction time
      Light.reactionTime();
      //System.out.println(OFFdelay);
    } catch (InterruptedException e) {
      Light.reactionTime();
      //System.out.println("Lights out bc of errror: " + e);
    }



*/

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main {
private static long startTime; // Time when lights go off
private static ArrayList<Light> lights = new ArrayList<>(); // List of Light objects

public static void main(String[] args) {

  // Timer delays
  int min = 500;
  int max = 3750;
  int w = max - min;

  int ONdelay = 1300;
  int OFFdelay = (int) (min + (Math.random() * w)); // Random delay between 0.5s and 3.75s

  // Create JFrame for the reaction timer
  JFrame frame = new JFrame("Reaction Timer");
  frame.setSize(400, 200);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);

  // Add instruction label
  JLabel label = new JLabel("Lights turning on... Watch the terminal closely!", SwingConstants.CENTER);
  frame.add(label);
  System.out.println("\nPress SPACEBAR immediately at Lights Out!\n");
 
  // Show JFrame
  frame.setVisible(true);

  // Create lights and turn them on
  for (int i = 0; i < 5; i++) {
    lights.add(new Light(i + 1)); // Create a new light
    try {
      Thread.sleep(ONdelay); // Delay for each light
    } catch (InterruptedException e) {
      System.out.println("ON delay error: " + e);
      break;
    }
  }

  // Turn lights off
  for (int i = 0; i < 5; i++) {
    lights.get(i).lightsOut(i + 1);
  }

  // Wait for random delay after lights out
  try {
    Thread.sleep(OFFdelay);
  } catch (InterruptedException e) {
    System.out.println("OFF delay interrupted: " + e);
  }

  // Update label to signal "lights out" and start reaction timing
  System.out.println("\nLIGHTS OUT! (press spacebar)");
  label.setText("LIGHTS OUT! Press SPACEBAR now!");
  startTime = System.nanoTime();

  // Add KeyListener to detect spacebar press
  frame.addKeyListener(new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
      // Detect spacebar press
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        long endTime = System.nanoTime(); // Record the reaction time
        long reactionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        // Display reaction time
        label.setText("Your reaction time: " + reactionTime + " ms");
        System.out.println("\nReaction Time: " + reactionTime + " ms");

        // Call Light's reactionTime method
        Light.reactionTime();

        // Remove the KeyListener to prevent multiple inputs
        frame.removeKeyListener(this);
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    });
  }
}
