package com.pravin.coding.canvas.shapes.parser;

import com.pravin.coding.canvas.actions.Action;

@FunctionalInterface
public interface ActionParser {

    Action parseEachParser(String command);
}
