package edu.monmouth.socket;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Supply IP or name of the server");
            System.exit(-1);
        }

        try {
            int port = 3000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            // Accept a request from a client
            Socket client = serverSocket.accept();

            // Get client's InetAddress and ports
            InetAddress clientAddress = client.getInetAddress();
            int remotePort = client.getPort();
            int localPort = client.getLocalPort();

            // Prepare the message to send to the client
            String message = "Hi, this is Juliana pleased to meet you! I see you are coming from " +
                             clientAddress.getHostAddress() + " using your remote port " + remotePort +
                             " accessing my port " + localPort;

            // Get an OutputStream for writing to the client
            OutputStream os = client.getOutputStream();
            PrintWriter writer = new PrintWriter(os, true);

            // Send the message to the client
            writer.println(message);

            // Close the server socket
            serverSocket.close();

        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}