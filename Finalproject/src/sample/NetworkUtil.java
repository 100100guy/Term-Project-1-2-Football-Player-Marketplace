package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class NetworkUtil  {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public NetworkUtil(String s, int port) throws IOException {
        this.socket = new Socket(s, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public NetworkUtil(Socket s) throws IOException {
        this.socket = s;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void write(Object o) throws IOException {
        oos.writeObject(o);
        oos.flush();
        oos.reset();
    }

    public void closeConnection() throws IOException {
        ois.close();
        oos.close();
    }
}

