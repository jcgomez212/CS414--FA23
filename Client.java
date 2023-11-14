package edu.monmouth.socket;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Client <server-ip>");
            System.exit(-1);
        }

        try {
            String serverIP = args[0];
            int serverPort = 3000;
            Socket socket = new Socket(serverIP, serverPort);

            // Create a BufferedReader to read messages from the server
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Read and print the message received from the server
            String message = br.readLine();
            System.out.println(message);

            // Close the client socket
            socket.close();

        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}