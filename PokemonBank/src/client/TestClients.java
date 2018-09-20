package client;

import java.io.IOException;
import java.net.UnknownHostException;

import shared.Pokemon;

public class TestClients {

    /**
     * Client application entry point.
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) {

        try {
            /*
             * A first trainer (Ash) will connect to the bank, and store his Pokemons.
             */
            PokemonTrainer ash = new PokemonTrainer();
            ash.getPokemonList();
            ash.sendPokemon(new Pokemon("Pikachu", 100));
            ash.sendPokemon(new Pokemon("Dracaufeu", 36));
            ash.disconnect();

            /*
             * A second trainer (Misty) will then store hers.
             */
            PokemonTrainer misty = new PokemonTrainer();
            misty.getPokemonList();
            misty.sendPokemon(new Pokemon("Magikarp", 5));
            misty.sendPokemon(new Pokemon("Psykokwak", 20));
            misty.disconnect();
        } catch (Exception e) {
            /*
             * We will not handle exceptions in this project.
             */
            e.printStackTrace();
        }
    }

}
