package com.KonList.model;

public enum Rating {
    G("G - ALL AGES"),
    PG("PG - CHILDREN"),
    PG13("PG-13 - TEENS 13 OR OLDER"),
    R("R - 17+ (VIOLENCE OR PROFANITY)"),
    RPLUS("R+ - MILD NUDITY"),
    RX("Rx - HENTAI");


    private String rating;

    Rating(String rating) {
        this.rating = rating;
    }

    public static Rating fromString(String text) {
        if (text == null) return null;

        String normalized = text.trim().toUpperCase();

        if (normalized.startsWith("G")) return G;
        if (normalized.startsWith("PG-13")) return PG13;
        if (normalized.startsWith("PG")) return PG;
        if (normalized.startsWith("R+")) return RPLUS;
        if (normalized.startsWith("R -")) return R;
        if (normalized.startsWith("RX")) return RX;

        throw new IllegalArgumentException("Unknown rating :" + text);
    }
}
