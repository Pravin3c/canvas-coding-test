package com.pravin.coding.canvas.utils;

import java.util.ArrayDeque;
import java.util.Deque;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Canvas;

public class ShapeDrawer {
	private final Deque<Action> actions = new ArrayDeque<>();
	private final Canvas canvas;

	public ShapeDrawer(Canvas canvas) {
		this.canvas = canvas;
	}

	public ShapeDrawer(Coordinates size) {
		this.canvas = new Canvas(size);
	}

	public void addAction(Action action) {
		action.validate(canvas);
		actions.addLast(action);
		action.apply(canvas);
	}

	public void invalidate() {
		actions.forEach(a -> a.apply(canvas));
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
