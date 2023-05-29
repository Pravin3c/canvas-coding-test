package com.pravin.coding.canvas.actions;

import com.pravin.coding.canvas.CanvasProcessor;
import com.pravin.coding.canvas.shapes.Canvas;

public interface Action {
    void execute(CanvasProcessor processor);

    void validate(Canvas canvas);

    void apply(Canvas canvas);
    
    Type getType();

    enum Type {
        DRAW,
        APPLICATION
    }
}
