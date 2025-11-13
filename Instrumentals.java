package assignment2;

interface Playable {
 void play();  
}

abstract class Instrument {
 String name;

 Instrument(String name) {
     this.name = name;
 }

 abstract void tune();

 void display() {
     System.out.println("Instrument: " + name);
 }
}

class Guitar extends Instrument implements Playable {
 Guitar(String name) {
     super(name);
 }

 void tune() {
     System.out.println(name + " is being tuned.");
 }

 public void play() {
     System.out.println("Playing " + name + " with strings.");
 }
}

class Piano extends Instrument implements Playable {
 Piano(String name) {
     super(name);
 }

 void tune() {
     System.out.println(name + " is being tuned.");
 }

 public void play() {
     System.out.println("Playing " + name + " with keys.");
 }
}

public class Instrumentals {
 public static void main(String[] args) {
     Playable g = new Guitar("Guitar");
     Playable p = new Piano("Piano");

     ((Instrument) g).display();
     ((Instrument) g).tune();
     g.play();

     System.out.println();

     ((Instrument) p).display();
     ((Instrument) p).tune();
     p.play();
 }
}
