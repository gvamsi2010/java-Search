import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private String location;
    private int age;

    public Person(String name, String location, int age) {
        this.name = name;
        this.location = location;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }
}

public class PersonSearch {
    private static final List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        // Adding sample data
        persons.add(new Person("Vamsi", "Dallas", 26));
        persons.add(new Person("Ajay p", "Arkansas", 24));
        persons.add(new Person("Pavan", "Wichita", 18));
        persons.add(new Person("Anil", "Kansas", 20));
        persons.add(new Person("Deepthi", "Irving", 22));
        persons.add(new Person("Sai", "Oklahoma", 28));
        persons.add(new Person("Naveen", "Huston", 27));
        persons.add(new Person("Mani", "New York", 25));

        // Start the web server
        startServer();
    }

    private static void startServer() {
        // Create a simple HTTP server
        com.sun.net.httpserver.HttpServer server;
        try {
            server = com.sun.net.httpserver.HttpServer.create(new java.net.InetSocketAddress(8000), 0);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

        // Add a context for the search page
        server.createContext("/search", new SearchHandler());

        // Set up the executor
        server.setExecutor(java.util.concurrent.Executors.newFixedThreadPool(10));

        // Start the server
        server.start();
    }

    // Handler for the search page
    static class SearchHandler implements com.sun.net.httpserver.HttpHandler {
        @Override
        public void handle(com.sun.net.httpserver.HttpExchange t) throws java.io.IOException {
            // Read the HTML file into a string
            java.nio.file.Path path = java.nio.file.Paths.get("search.html");
            String html = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);

            // Send the HTML response
            t.sendResponseHeaders(200, html.length());
            java.io.OutputStream os = t.getResponseBody();
            os.write(html.getBytes());
            os.close();
        }
    }
}
