package designpatterns.facade;

import java.util.ArrayList;
import java.util.List;

// Pronounce as "Fasad"
// house example
// many sub systems, complex internal strucure, not expoxed to internals
// Provides a simple, easy to understand/user interface over a large
// and sophisticated body of code.
public class Facade {
  public static void main(String[] args) {
    /*Buffer buffer = new Buffer(30, 20);
    Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
    Console console = new Console(30, 20);
    console.addViewport(viewport);
    console.render();*/ // Add api for this chunk of code is facade
    Console console = Console.newConsole(30, 20);
    console.render(); 
  }
}

class Buffer {
  private char[] characters;
  private int lineWidth;
  
  public Buffer(int lineHeight, int lineWidth) {
    this.lineWidth = lineWidth;
    characters = new char[lineWidth * lineHeight];
  }
  
  public char charAt(int x, int y) {
    return characters[y*lineWidth+x];
  }
}


class Viewport {
  private Buffer buffer;
  private int width;
  private int height;
  private int offsetX;
  private int offsetY;
  
  public Viewport(Buffer buffer, int width, int height, int offsetX, int offsetY) {
    this.buffer = buffer;
    this.width = width;
    this.height = height;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
  }
  
  public char charAt(int x, int y) {
    return buffer.charAt(x+offsetX, y+offsetY); 
  }
}

class Console {
  private List<Viewport> viewports = new ArrayList<>();
  int width, height;
  public Console(int width, int height) {
    this.width = width;
    this.height = height;
  }
  public void addViewport(Viewport viewport) {
    viewports.add(viewport);
  }
  
  public static Console newConsole(int width, int height) {
    Buffer buffer = new Buffer(width, height);
    Viewport viewport = new Viewport(buffer, width, height, 0, 0);
    Console console = new Console(width, height);
    console.addViewport(viewport);
    return console;
  }
  public void render() {
    for(int y=0; y<height; y++) {
      for(int x=0; x<width; x++) {
        for(Viewport vp : viewports) {
          System.out.print(vp.charAt(x, y));
        }
        System.out.println();
      }
    }
  }
}