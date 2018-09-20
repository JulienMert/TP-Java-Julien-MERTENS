package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import shared.Pokemon;
import shared.Request;

/*
 * This class represents a Pokémon Bank client, which is a Pokémon Trainer.
 * @author strift
 *
 */
public class PokemonTrainer {

    public static final String SERVER_HOST = null; // localhost
    public static final int SERVER_PORT = 3000;

    /**
     * The client socket
     */
    private Socket client;

    /**
     * The client output stream
     */
    private ObjectOutputStream outputStream;

    /**
     * The client input stream
     */
    private ObjectInputStream inputStream;

    /**
     * Constructor
     * @throws UnknownHostException
     * @throws IOException
     */
    public PokemonTrainer() throws UnknownHostException, IOException {
        /*
         * TODO
         * Here you initialize the socket, the input stream, and the output stream
         */
        this.client = new Socket(SERVER_HOST, SERVER_PORT);
        this.outputStream = new ObjectOutputStream(this.client.getOutputStream());
        this.inputStream = new ObjectInputStream(this.client.getInputStream());

    }

    /**
     * Send a LIST request to the server and read its response
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getPokemonList() throws IOException, ClassNotFoundException {
        System.out.println("Request: LIST");
        /*
         * TODO
         * Here you should write the request to the output stream.
         */
        this.outputStream.writeObject("LIST");

        this.readResponse();
    }

    /**
     * Send a STORE request to the server and read its response
     * @param pokemon
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void sendPokemon(Pokemon pokemon) throws IOException, ClassNotFoundException {
        System.out.println("Request: STORE");
        /*
         * TODO
         * Here you should write the request to the output stream, then write the Pokémon to send.
         */
        this.outputStream.writeObject("STORE");
        this.outputStream.writeObject(pokemon);

        System.out.println("Envoi du pokémon : " + pokemon +" en cours");
        this.readResponse();
    }

    /**
     * Send a CLOSE request to the server, read its response, and close everything
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void disconnect() throws IOException, ClassNotFoundException {
        System.out.println("Request: CLOSE");
        /*
         * TODO
         * Here you should write the request to the output stream.
         */
        this.outputStream.writeObject("CLOSE");
        this.readResponse();

        /*
         * TODO
         * Here you should close both I/O streams and the socket.
         */
        this.inputStream.close();
        this.outputStream.close();
    }

    /**
     * Read the response from the server
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private void readResponse() throws ClassNotFoundException, IOException {
        /*
         * TODO
         * Here you should read the server response from the input stream, then print it.
         * Note: the server only answers with String ;)
         */
        String response = (String) this.inputStream.readObject();
        System.out.println(response);
    }
}

