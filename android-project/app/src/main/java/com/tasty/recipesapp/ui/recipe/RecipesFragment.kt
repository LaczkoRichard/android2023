package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RecipesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipesFragment : Fragment() {

    private val TAG: String? = RecipesFragment::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.recipesRecyclerView)

        context?.let { viewModel.fetchRecipeData(it) }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            val adapter = RecipeListAdapter(
                recipes,
                requireContext(),

                onItemClick = {
                        currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                },

                onDetailsClick = {
                        currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                }
            )
            // Attach adapter to recycler view
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView.adapter = adapter
        }
    }

}