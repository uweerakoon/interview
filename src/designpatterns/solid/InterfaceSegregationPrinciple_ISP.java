package designpatterns.solid;
// One interface is not sutable for other classes, so 
// decompose the interface into small once to get rid of
// NotStubbedException 
public class InterfaceSegregationPrinciple_ISP {

}


class Document {

}

interface Machine {
  void print(Document d);
  void fax(Document d);
  void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

  @Override
  public void print(Document d) {


  }

  @Override
  public void fax(Document d) {


  }

  @Override
  public void scan(Document d) {


  }

}

// no fax or scan - interface is bad
class OldFashionPrinter implements Machine {
  @Override
  public void print(Document d) {


  }

  @Override
  public void fax(Document d) {


  }

  @Override
  public void scan(Document d) {


  }
}

interface Printer {
  void print(Document d);
}

interface Scanner {
  void scan(Document d);
}

// YAGNI = You Ain't going to need it
class JustAPrinter implements Printer {
  @Override
  public void print(Document d) {


  }
}

class PhotoCopier implements Printer, Scanner {

  @Override
  public void scan(Document d) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    
  }
  
}

interface MutiFunctionDevice extends Printer, Scanner {}
// segregation interface
class MultiFunctionMachine implements MutiFunctionDevice {

  private Printer printer;
  private Scanner scanner;
  @Override
  public void print(Document d) {
    printer.print(d);
  }

  @Override
  public void scan(Document d) {
    scanner.scan(d);
  }
  
}