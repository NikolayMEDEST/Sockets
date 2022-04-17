import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 8089;
         try (ServerSocket serverSocket = new ServerSocket(port)) {

             while (true) {
                 // ServerSocket serverSocket = new ServerSocket(port);
                 // ждем подключения
                 Socket connection = serverSocket.accept();
                 // отправляем сообщения
                 try (PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                     System.out.printf("Принято новое соединение на порту %d%n", connection.getPort());
                     // ждем строку от клиента
                     String name = in.readLine();
                     // отвечаем клиенту
                     out.println(String.format(" Привет, %s, твой порт %d", name, connection.getPort()));
                     // закрываем соединение
                     // serverSocket.close();
                 }  catch (IOException e) {
                 e.printStackTrace();
             }
         }
         } catch (IOException e) {
             e.printStackTrace();
         }


    }


}
