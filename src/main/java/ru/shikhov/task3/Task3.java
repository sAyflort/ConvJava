package ru.shikhov.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Figure> figures = List.of(new Circle(), new Square(), new Triangle());
        for (Figure f: figures
             ) {
            f.draw();
        }
    }
}
