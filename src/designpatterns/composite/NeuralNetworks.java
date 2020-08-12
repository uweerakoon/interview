package designpatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class NeuralNetworks {
  public static void main(String[] args) {
    Neuron neuron = new Neuron();
    Neuron neuron2 = new Neuron();
    NeuronLayer layer = new NeuronLayer();
    NeuronLayer layer2 = new NeuronLayer();
    
    neuron.connectTo(neuron2);
    neuron.connectTo(layer);
    layer.connectTo(neuron);
    layer.connectTo(layer2);
  }
}

interface SomeNeurons extends Iterable<Neuron> {
  default void connectTo(SomeNeurons other) {
    if(this == other) return;
    for(Neuron from : this) {
      for(Neuron to : other) {
        from.out.add(to);
        to.in.add(from);
      }
    }
  }
}

class Neuron implements SomeNeurons {
  public List<Neuron> in, out;
//  public void connectTo(Neuron other) { // need to statisfy all four implementation
//    out.add(other);
//    other.in.add(this);
//  }
   @Override
   public Iterator<Neuron> iterator() {
     return Collections.singleton(this).iterator();
   }
   
   @Override
   public void forEach(Consumer<? super Neuron> action) {
     action.accept(this);
   }
   
   @Override
   public Spliterator<Neuron> spliterator() {
     return Collections.singleton(this).spliterator();
   }
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {
  
}