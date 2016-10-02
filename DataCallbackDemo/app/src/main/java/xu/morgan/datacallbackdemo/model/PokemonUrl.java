package xu.morgan.datacallbackdemo.model;

/**
 * Created by morganxu on 2/10/2016.
 */
public class PokemonUrl {
    private String pokemonName;
    private String pokeUrl;

    public PokemonUrl(String pokemonName, String pokeUrl) {
        this.pokemonName = pokemonName;
        this.pokeUrl = pokeUrl;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokeUrl() {
        return pokeUrl;
    }

    public void setPokeUrl(String pokeUrl) {
        this.pokeUrl = pokeUrl;
    }
}
