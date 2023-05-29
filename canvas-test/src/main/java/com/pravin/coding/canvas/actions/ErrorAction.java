package com.pravin.coding.canvas.actions;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.shapes.Canvas;

public class ErrorAction implements Action {

	private final String desc;
	private final Throwable error;

	public ErrorAction(String desc) {
		this.desc = desc;
		error = null;
	}

	public ErrorAction(String desc, Throwable error) {
		this.desc = desc + ":" + error.getMessage();
		this.error = error;
	}

	@Override
	public void execute(CanvasProcessor processor) {
		System.out.println(desc);
	}

	@Override
	public Type getType() {
		return Type.APPLICATION;
	}

	public String toString() {
		return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("desc", desc).toString();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ErrorAction that = (ErrorAction) o;
		return Objects.equals(desc, that.desc);
	}

	public int hashCode() {

		return Objects.hash(desc);
	}

	@Override
	public void validate(Canvas canvas) {
		
	}

	@Override
	public void apply(Canvas canvas) {
		
	}

}
