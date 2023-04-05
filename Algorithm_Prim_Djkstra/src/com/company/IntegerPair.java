package com.company;

public class IntegerPair implements Comparable{
    Integer _first, _second;

    public IntegerPair(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(Object o) {
        if (this.first() != ((IntegerPair )o).first())
            return  ((IntegerPair )o).first() - this.first();
        else
            return  ((IntegerPair )o).second() - this.second();
//        if (this.first() != ((IntegerPair) o).first())
//            return ((IntegerPair) o).first() - this.first();
//        else
//            return  ((IntegerPair) o).second() - this.second();
    }
    Integer first() {
        return _first;
    }
    Integer second() {
        return _second;
    }


}
