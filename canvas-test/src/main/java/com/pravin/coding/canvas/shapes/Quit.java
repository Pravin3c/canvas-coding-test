package com.pravin.coding.canvas.shapes;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.actions.Action;

public class Quit implements Action {

    @Override
    public void execute(CanvasProcessor processor) {
    	processor.quit();
    }

    @Override
    public Type getType() {
        return Type.APPLICATION;
    }

	@Override
	public void validate(Canvas canvas) {
	
	}

	@Override
	public void apply(Canvas canvas) {
	
	}
}
