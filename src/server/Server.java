package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23444);


        while (true) {

            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String line;
                while ((line = in.readLine()) != null) {
                    long firstNumber = 0;
                    long secondNumber = 1;
                    long calculatedNumber = 0;
                    int userNumber = Integer.parseInt(line);

                    int iteration = userNumber - 2;

                    for (int i = 0; i < iteration; i++) {
                        calculatedNumber = firstNumber + secondNumber;
                        secondNumber = calculatedNumber;
                        firstNumber = calculatedNumber - firstNumber;
                    }

                    out.println(Long.toString(calculatedNumber));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
