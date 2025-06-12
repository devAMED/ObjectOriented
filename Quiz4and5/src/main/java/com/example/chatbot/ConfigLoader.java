package com.example.chatbot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Utility that loads settings from config.txt and returns a Config object. */
public final class ConfigLoader {
    private ConfigLoader() { }

    public static Config load(String file) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(file));

        String url   = null;
        String name  = null;
        String key   = null;
        String token = null;
        int timeout  = 5;   // default

        for (String l : lines) {
            l = l.trim();
            if (l.isEmpty() || l.startsWith("#")) continue;
            if (l.startsWith("api.url="))            url   = l.substring(8).trim();
            else if (l.startsWith("bot.name="))      name  = l.substring(9).trim();
            else if (l.startsWith("api.key="))       key   = l.substring(8).trim();
            else if (l.startsWith("auth.token="))    token = l.substring(11).trim();
            else if (l.startsWith("timeout.seconds="))
                timeout = Integer.parseInt(l.substring(16).trim());
        }

        if (url == null || name == null)
            throw new IllegalArgumentException("config.txt missing api.url or bot.name");

        return new Config(url, name, key, token, timeout);
    }
}