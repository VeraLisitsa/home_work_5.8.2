import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Server started");
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    out.println("Write your name");
                    Thread.sleep(15000);
                    String name = in.readLine();
                    System.out.println(name);
                    out.println("Are you child? (yes/no)");
                    Thread.sleep(15000);
                    String isChild = in.readLine();
                    System.out.println(isChild);
                    if(isChild.equals("yes")){
                        out.printf("Welcome to the kids area, %s! Let's play!", name);
                    } else if(isChild.equals("no")){
                        out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
                    } else {
                        out.println("Good buy!");
                    }
                }

            }
        }
    }
}

