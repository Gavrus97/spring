package com.example.points.point_exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PointsExerciseTest {


    @Test
    @DisplayName("method throws IllegalArgumentException when me point is null")
    public void getNearestLocationsThrowsWhenMeNull() {
        List<Point> points = Arrays.asList(
                new Point(2, 4),
                new Point(3, 4),
                new Point(2, 3)
        );

        Point me = null;

        var expectedMessage = "Me cannot be null";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PointsExercise.getNearestLocations(me, points, 2)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }


    @Test
    @DisplayName("method throws IllegalArgumentException when results is less then 0 or equals 0")
    public void getNearestLocationsThrowsWhenResultsLessOrEqualsZero() {
        List<Point> points = Arrays.asList(
                new Point(2, 4),
                new Point(3, 4),
                new Point(2, 3)
        );

        Point me = new Point(2,3);

        var expectedMessage = "Results cannot be negative or zero";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PointsExercise.getNearestLocations(me, points, 0)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }


    @Test
    @DisplayName("method throws IllegalArgumentException when list of points is null")
    public void getNearestLocationsThrowsWhenPointsNull() {
        List<Point> points = null;

        Point me = new Point(2,3);

        var expectedMessage = "Points cannot be null";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PointsExercise.getNearestLocations(me, points, 2)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }
}
