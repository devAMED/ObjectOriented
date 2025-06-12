package com.example.chatbot;

/** Immutable settings bag (Java-11-compatible). */
public final class Config {
    private final String url;
    private final String botName;
    private final String apiKey;
    private final String authToken;
    private final int timeoutSec;

    public Config(String url, String botName,
                  String apiKey, String authToken, int timeoutSec) {
        this.url = url;
        this.botName = botName;
        this.apiKey = apiKey;
        this.authToken = authToken;
        this.timeoutSec = timeoutSec;
    }

    public String url()        { return url; }
    public String botName()    { return botName; }
    public String apiKey()     { return apiKey; }
    public String authToken()  { return authToken; }
    public int    timeoutSec() { return timeoutSec; }
}