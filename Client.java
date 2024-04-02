import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("连接到服务器：" + socket);

            // 上传文件
            uploadFile(socket, "example.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uploadFile(Socket socket, String fileName) {
        try (
                OutputStream os = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(os);
                FileInputStream fileInputStream = new FileInputStream(fileName)
        ) {
            // 发送文件名
            dataOutputStream.writeUTF(fileName);

            // 读取文件并发送
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            System.out.println("文件上传完成：" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
