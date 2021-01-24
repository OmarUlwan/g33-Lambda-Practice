package se.lexicon.omar.model;

@FunctionalInterface
public interface Conditional {
    boolean test(Product p);
}
