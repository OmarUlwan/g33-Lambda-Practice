package se.lexicon.omar.model;

@FunctionalInterface
public interface Action{
    void execute(Product p);
}
