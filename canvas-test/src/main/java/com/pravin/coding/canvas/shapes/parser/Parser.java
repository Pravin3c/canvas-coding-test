package com.pravin.coding.canvas.shapes.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pravin.coding.canvas.actions.Action;
import com.pravin.coding.canvas.actions.ErrorAction;

public class Parser {
    private static final Logger log = LogManager.getLogger(Parser.class);
    private final List<ActionParser> parsers;

    public Parser(List<ActionParser> parsers) {
        this.parsers = parsers;
    }

    /**
     * parse the input command
     * @param raw
     * @return
     */
    public Action parse(String command) {
        List<Action> result = new ArrayList<>();
        try {
            result = parsers.stream()
                    .map(p -> p.parseEachParser(command))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception parsing {}", command, e);
            return new ErrorAction("Exception when parsing the action: " + e);
        }

        if (result.size() > 1) {
            log.error("More than one action match command {} : {} ", command, result);
            return new ErrorAction("More than one action match command " + command + " : " + result);
        }

        if (result.isEmpty()) {
            log.error("Unknown command: {}", command);
            return new ErrorAction("Unknown command: " + command);
        }
        log.info("Command {} parsed as {} ", command, result);
        return result.get(0);

    }
    
    
}
