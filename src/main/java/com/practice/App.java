package com.practice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private static final int PORT = 5000;

    private App() {
        // Utility class, not meant to be instantiated.
    }

    public static void main(String[] args) throws IOException {
        // Binds to 0.0.0.0 so the container port is reachable from the host.
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", App::handleRoot);
        server.createContext("/health", App::handleHealth);
        server.setExecutor(null);
        server.start();

        LOGGER.info(() -> "Practice application is running on port " + PORT);
    }

    private static void handleRoot(HttpExchange exchange) throws IOException {
        respond(exchange, "Practice application is running\n");
    }

    private static void handleHealth(HttpExchange exchange) throws IOException {
        respond(exchange, "UP\n");
    }

    private static void respond(HttpExchange exchange, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }
}