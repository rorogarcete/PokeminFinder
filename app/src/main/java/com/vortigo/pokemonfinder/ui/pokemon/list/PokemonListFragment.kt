package com.vortigo.pokemonfinder.ui.pokemon.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference

class PokemonListFragment: BaseFragment(), PokemonListContract.PokemonView {

    @Inject lateinit var presenter: PokemonListContract.PokemonPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private var pokemonAdapter = PokemonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        progressBar = view.findViewById(R.id.progress_indicator)

        recyclerView = view.findViewById(R.id.pokemonRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.hasFixedSize()
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))

        //pokemonAdapter = PokemonAdapter()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInjection()
        presenter.attachView(this)

        getPokemonsFavorite()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    // TODO Implemnt snackbar for show error
    override fun onEntityError(error: String) {}

    override fun loadPokemons(pokemons: List<Pokemon>) {
        pokemonAdapter.setList(pokemons)
        recyclerView.adapter = pokemonAdapter
    }

    public fun loadPokemonsByFinder(pokemons: List<Pokemon>) {
        pokemonAdapter.setList(pokemons)
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    private fun getPokemonsFavorite() {
        val type = PokemonPreference().getTypeFavorite(activity!!.baseContext)
        presenter.getPokemonsFavoriteByType(type)
    }

    companion object {
        @JvmStatic
        fun newInstance(): PokemonListFragment {
            val fragment = PokemonListFragment()

            return fragment
        }
    }
}
