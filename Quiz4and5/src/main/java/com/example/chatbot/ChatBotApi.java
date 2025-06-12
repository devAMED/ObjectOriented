package com.example.chatbot;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;


public final class ChatBotApi {

    private static final String BLOGS_PATH = "?api=blogs";
    private static final String STATS_PATH = "?api=stats";

    private final String base;            // e.g. https://max.ge/.../index.php
    private final HttpClient client = HttpClient.newHttpClient();
    private final String apiKey;          // nullable
    private final String bearer;          // nullable
    private final Duration timeout;

    public ChatBotApi(Config cfg) {
        this.base   = cfg.url().endsWith("/") ? cfg.url() : cfg.url() + "/";
        this.apiKey = cfg.apiKey();
        this.bearer = cfg.authToken();
        this.timeout = Duration.ofSeconds(cfg.timeoutSec());
    }

    /* ---------- public wrappers ---------- */
    public String getAllBlogs()        throws Exception { return send("GET",  BLOGS_PATH, null); }
    public String getStats()           throws Exception { return send("GET",  STATS_PATH, null); }
    public String createBlog(String j) throws Exception { return send("POST", BLOGS_PATH, j);   }

    /* ---------- internal sender ---------- */
    private String send(String method, String endpoint, String body) throws Exception {

        String fullUrl = base + endpoint + buildKeyParam();

        HttpRequest.Builder b = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .header("Content-Type", "application/json; charset=UTF-8")
                .timeout(timeout);

        if (bearer != null && !bearer.isEmpty())
            b.header("Authorization", "Bearer " + bearer);

        if ("POST".equals(method))
            b.POST(HttpRequest.BodyPublishers.ofString(body == null ? "" : body));
        else
            b.GET();

        try {
            HttpResponse<String> r = client.send(b.build(), HttpResponse.BodyHandlers.ofString());
            if (r.statusCode() / 100 != 2)
                throw new RuntimeException("HTTP " + r.statusCode() + ": " + r.body());
            return r.body();
        } catch (HttpTimeoutException e) {
            throw new RuntimeException("Request timed out after "
                    + timeout.toSeconds() + " s");
        }
    }

    private String buildKeyParam() {
        if (apiKey == null || apiKey.isEmpty()) return "";
        String encoded = URLEncoder.encode(apiKey, StandardCharsets.UTF_8);
        return (BLOGS_PATH.contains("?") ? "&" : "?") + "api_key=" + encoded;
    }
}