import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class log4j {
    private static final Logger logger = LogManager.getLogger(log4j.class);

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            System.out.println("Received new request");

            InputStream is = t.getRequestBody();
            String body = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));    

            System.out.printf("Logging body content: %s\n", body);
            logger.error(body);

            String response = "OK";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RootHandler());
        server.setExecutor(null); // creates a default executor

        System.out.println("Starting HTTP server on port 8080");
        server.start();
    }

    public static void createSecret() throws IOException {
        Random r = new Random();
        byte[] randomString = new byte[64];
        
        for (int i=0; i<randomString.length; i++) {
            randomString[i] = (byte)(r.nextInt(52) + 'A');
        }
        FileUtils.writeByteArrayToFile(new File("/secret.txt"), randomString);
    }

    public static void main(String[] args) throws IOException {
        createSecret();
        startServer();
    }
}
