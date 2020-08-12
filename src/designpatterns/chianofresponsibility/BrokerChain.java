package designpatterns.chianofresponsibility;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import designpatterns.chianofresponsibility.Query.Argument;

/**
 * This is not working for java 8, shoudl work in java 9
 * Command Query Separation: 
 *   Command = asking for an action or change
 *   Query = asking for information
 *   CQS = having seperate means of sending 
 *          commands and queries to e.g. direct field access
 * @author udaraweerakoon
 *
 */
public class BrokerChain {
  public static void main(String[] args) {
    Game1 game = new Game1();
    Creature1 goblin = new Creature1(game, "Strong Goblin", 2, 2);
    
    System.out.println(goblin);
    
    IncreasedDefenseModifier1 icm = new IncreasedDefenseModifier1(game, goblin);
    DoubleAttackModifier1 dam = new DoubleAttackModifier1(game, goblin);
//    try(dam) {
      System.out.println(goblin);
//    }
    System.out.println(goblin);
  }
}

// cor + observer + mediator + (-) momento
class Event<Args> {
  private int index = 0;
  private Map<Integer, Consumer<Args>> handlers = new HashMap<>();
  
  public int subscribe(Consumer<Args> handler) {
    int i = index;
    handlers.put(index++, handler);
    return i;
  }
  
  public void unsubscribe(int key) {
    handlers.remove(key);
  }
  
  public void fire(Args args) {
    for(Consumer<Args> handler : handlers.values()) {
      handler.accept(args); 
    }
  }
}

class Query {
  public String creatureName;
  enum Argument {
    ATTACK, DEFENSE;
  }
  public Argument argument;
  public int result;
  public Query(String creatureName, Argument argument, int result) {
    super();
    this.creatureName = creatureName;
    this.argument = argument;
    this.result = result;
  } 
}

class Game1 {
  public Event<Query> queries = new Event();
}

class Creature1 {
  private Game1 game1;
  public String name;
  public int baseAttack, baseDefense;
  public Creature1(Game1 game1, String name, int baseAttack, int baseDefense) {
    super();
    this.game1 = game1;
    this.name = name;
    this.baseAttack = baseAttack;
    this.baseDefense = baseDefense;
  }
  
  int getAttack() {
    Query query = new Query(name, Argument.ATTACK, baseAttack);
    game1.queries.fire(query);
    return query.result;
  }

  @Override
  public String toString() {
    return "Creature [game=" + game1 + ", name=" + name + ", attack=" + baseAttack + ", defense=" + baseDefense
      + "]";
  }
}

class CreatureModifier1 {
  protected Game1 game1;
  protected Creature1 creature1;
  public CreatureModifier1(Game1 game1, Creature1 creature1) {
    super();
    this.game1 = game1;
    this.creature1 = creature1;
  }
}

class DoubleAttackModifier1 extends CreatureModifier1 implements AutoCloseable {
  private final int token;
  public DoubleAttackModifier1(Game1 game1, Creature1 creature1) {
    super(game1, creature1);
    token = game1.queries.subscribe(q -> {
      if(q.creatureName.equals(creature1.name)
          && q.argument == Query.Argument.ATTACK) {
        q.result *= 2;
      }
    });
  }
  
  @Override
  public void close() {
    game1.queries.unsubscribe(token);
  }
}

class IncreasedDefenseModifier1 extends CreatureModifier1 {
  public IncreasedDefenseModifier1(Game1 game1, Creature1 creature) {
    super(game1, creature);
    game1.queries.subscribe(q -> {
      if(q.creatureName.equals(creature.name)
          && q.argument == Query.Argument.DEFENSE) {
        q.result += 3;
      }
    });
  }
}