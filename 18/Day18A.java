import java.util.*;
import java.io.*;

public class Day18A {
    private static Scanner in;
    private static class SnailfishNumber {
        Pair parent;
        SnailfishNumber(Pair parent) { this.parent = parent; }
        Number getLeft() { return parent == null ? null : equals(parent.l) ? parent.getLeft() : parent.l instanceof Number ? (Number)parent.l: ((Pair)parent.l).getLast(); }
        Number getRight() { return parent == null ? null : equals(parent.r) ? parent.getRight() : parent.r instanceof Number ? (Number)parent.r: ((Pair)parent.r).getFirst(); }
    }
    private static class Number extends SnailfishNumber {
        Integer val;
        Number(Pair parent, String c) {
            super(parent);
            val = Integer.valueOf(c);
        }
        public String toString() { return val.toString(); }
    }
    private static class Pair extends SnailfishNumber {
        Object l, r;
        Pair() { this(null); }
        Pair(Pair parent) {
            super(parent);
            String c = in.next();
            l = (c.equals("[")) ? new Pair(this) : new Number(this, c);
            in.next();
            c = in.next();
            r = (c.equals("[")) ? new Pair(this) : new Number(this, c);
            in.next();
            return;
        }
        Pair(Pair l, Pair r) { this(null, l, r); }
        Pair(Pair parent, Pair l, Pair r) {
            super(parent);
            this.l = l;
            this.r = r;
            l.parent = this;
            r.parent = this;
        }
        public String toString() { return "["+l.toString()+","+r.toString()+"]"; }
        static Pair sum(Pair l, Pair r) { return new Pair(l, r); }
        Number getLast() { return r instanceof Number ? (Number)r : ((Pair)r).getLast(); }
        Number getFirst() { return l instanceof Number ? (Number)l : ((Pair)l).getFirst(); }
    }
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File("Day18.in")).useDelimiter("\\r*\\n*");
        
        in.next();
        Pair p = new Pair();
        Pair q = new Pair();
        // p = new Pair(p, new Pair());
        System.out.println(p);
        System.out.println(q);
    }
}