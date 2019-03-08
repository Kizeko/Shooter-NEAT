package fr.kizeko.neat.utils;

import processing.core.PVector;

public class Functions {

    public static void moveForward(PVector position, PVector destination, float speed) {
        PVector direction = new PVector(destination.x - position.x, destination.y - position.y);
        direction.normalize();
        position.add(direction.x * speed, direction.y * speed);
    }

    public static void moveBackward(PVector position, PVector destination, float speed) {
        PVector direction = new PVector(position.x - destination.x, position.y - destination.y);
        direction.normalize();
        position.add(direction.x * speed, direction.y * speed);
    }
}
