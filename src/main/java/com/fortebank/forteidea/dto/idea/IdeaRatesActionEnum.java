package com.fortebank.forteidea.dto.idea;

public enum IdeaRatesActionEnum {
    LIKE("LIKE"),
    DISLIKE("DISLIKE");

    private String action;

    IdeaRatesActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
