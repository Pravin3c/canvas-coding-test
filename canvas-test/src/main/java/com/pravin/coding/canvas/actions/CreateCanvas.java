package com.pravin.coding.canvas.actions;

import java.util.Objects;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.coordinates.Coordinates;
import com.pravin.coding.canvas.shapes.Canvas;
import com.pravin.coding.canvas.utils.ShapeDrawer;

public class CreateCanvas implements Action {

	private final Coordinates size;

	public CreateCanvas(Coordinates size) {
		this.size = size;
	}

	@Override
	public void execute(CanvasProcessor processor) {
		processor.setDrawer(new ShapeDrawer(size));
	}

	@Override
	public Type getType() {
		return Type.APPLICATION;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CreateCanvas that = (CreateCanvas) o;
		return Objects.equals(size, that.size);
	}

	@Override
	public int hashCode() {

		return Objects.hash(size);
	}

	@Override
	public void validate(Canvas canvas) {
	
	}

	@Override
	public void apply(Canvas canvas) {
	
	}
}
