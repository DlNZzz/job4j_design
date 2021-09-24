package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> iParent = findBy(parent);
        if (findBy(child).isEmpty() && iParent.isPresent()) {
            Node<E> node = iParent.get();
            node.children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.add(root);
        Predicate<Node<E>> pred = f -> f.children.size() > 2;
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (findByPredicate(pred).isPresent()) {
                return false;
            }
            data.addAll(el.children);
        }
        return true;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.add(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        Predicate<Node<E>> predicate = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> eNode) {
                return eNode.value.equals(value);
            }
        };
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}