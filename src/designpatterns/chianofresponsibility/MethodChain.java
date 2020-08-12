package designpatterns.chianofresponsibility;
/**
 * A chain of components who all get a change to 
 * process a command or a query, optionally 
 * having default processing implementation
 * and an ability to terminate the 
 * processing chain
 * @author udaraweerakoon
 *
 */
public class MethodChain {
  public static void main(String[] args) {
    Creature goblin = new Creature("Goblin", 2, 2);
    CreatureModifier root = new CreatureModifier(goblin);
    
    // stop all the reponsibilites
    root.add(new NoBonusesModifier(goblin));
    
    System.out.println("Let's doble goblin's attack...");
    root.add(new DoubleAttackModifier(goblin));
    
    System.out.println("Let's increase goblin's defense");
    root.add(new IncreaseDefenseModifier(goblin));
    
    root.handle();
    System.out.println(goblin);
  }
}

class Creature {
  public String name;
  public int attack, defense;
  public Creature(String name, int attack, int defense) {
    super();
    this.name = name;
    this.attack = attack;
    this.defense = defense;
  }
  @Override
  public String toString() {
    return "Creature [name=" + name + ", attack=" + attack + ", defense=" + defense + "]";
  }
}

class CreatureModifier {
  protected Creature creature;
  protected CreatureModifier next; // chain of responsibility
  public CreatureModifier(Creature creature) {
    super();
    this.creature = creature;
  }
  
  public void add(CreatureModifier cm) {
    if(next != null) {
      next.add(cm);
    }
    else 
      next = cm;
  }
  
  public void handle() {
    if(next != null)
      next.handle();
  }
}


class DoubleAttackModifier extends CreatureModifier {
  public DoubleAttackModifier(Creature creature) {
    super(creature);
  }
  @Override
  public void handle() {
    System.out.println("Doubling "+creature.name+"'s attack");
    creature.attack *= 2;
    super.handle(); // critical
  }
}

class NoBonusesModifier extends CreatureModifier {

  public NoBonusesModifier(Creature creature) {
    super(creature);
  }
  
  @Override
  public void handle() {
    // nothing
    System.out.println("No bonuses for you!");
  }
}

class IncreaseDefenseModifier extends CreatureModifier {
  public IncreaseDefenseModifier(Creature creature) {
    super(creature);
  }
  @Override
  public void handle() {
    System.out.println("Increasing "+creature.name+"'s defense");
    creature.defense += 3;
    super.handle();
  }
}