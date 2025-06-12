package com.example.chatbot;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        try {

            Config cfg = ConfigLoader.load("config.txt");


            ChatBotApi api = new ChatBotApi(cfg);   // cfg, not cfg.url()


            runConsole(cfg.botName(), api);

        } catch (Exception e) {
            System.err.println("Startup error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void runConsole(String botName, ChatBotApi api) throws Exception {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("== " + botName + " ==");
            System.out.println("1) View all blog posts");
            System.out.println("2) Create a new post");
            System.out.println("3) View site statistics");
            System.out.print  ("0) Exit\n> ");

            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println(pretty(api.getAllBlogs()));
                    break;

                case "2":
                    System.out.print("Title   : "); String t = in.nextLine();
                    System.out.print("Author  : "); String a = in.nextLine();
                    System.out.print("Content : "); String c = in.nextLine();
                    String json = "{\"title\":\"" + t + "\","
                            + "\"content\":\"" + c + "\","
                            + "\"author\":\"" + a + "\"}";
                    System.out.println(pretty(api.createBlog(json)));
                    break;

                case "3":
                    System.out.println(pretty(api.getStats()));
                    break;

                case "0":
                    System.out.println("Good-bye!");
                    return;

                default:
                    System.out.println("Please choose 0-3.");
            }
        }
    }

    
    private static String pretty(String raw) {
        StringBuilder out = new StringBuilder();
        int indent = 0;
        for (char ch : raw.toCharArray()) {
            switch (ch) {
                case '{':
                case '[':
                    out.append(ch).append('\n');
                    indent++;
                    out.append("  ".repeat(indent));
                    break;
                case '}':
                case ']':
                    out.append('\n');
                    indent--;
                    out.append("  ".repeat(indent)).append(ch);
                    break;
                case ',':
                    out.append(ch).append('\n').append("  ".repeat(indent));
                    break;
                default:
                    out.append(ch);
            }
        }
        return out.toString();
    }
}
