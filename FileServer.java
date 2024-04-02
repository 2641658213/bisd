import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端连接成功：" + clientSocket);

                // 处理客户端请求
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                InputStream is = clientSocket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(is)
        ) {
            // 获取文件名和保存路径
            String fileName = dataInputStream.readUTF();
            String outputPath = "server_" + fileName;

            // 创建输出流，写入文件
            try (FileOutputStream fos = new FileOutputStream(new File(outputPath))) {
                byte[] buffer = new byte[1024];
                int len;

                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                System.out.println("文件接收完成：" + outputPath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}