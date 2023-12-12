package com.tasty.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.instruction.model.InstructionModel
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeDetailFragment : Fragment() {

    private val TAG = "RecipeDetailFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeId = arguments?.getInt("recipeId")
        Log.d(TAG, "Recipe id: $recipeId")

        val viewModel = ViewModelProvider(this)[RecipeDetailViewModel::class.java]

        recipeId?.let { viewModel.fetchRecipeDetail(this.requireActivity(), it) }

        viewModel.recipe.observe(viewLifecycleOwner) { it ->

            val titleView = view.findViewById<TextView>(R.id.detailRecipeTitle)
            titleView.text = it.name

            val descriptionView = view.findViewById<TextView>(R.id.recipeDescription)
            descriptionView.text = it.description

            val imageView = view.findViewById<ImageView>(R.id.detailRecipePhoto)
            context?.let { it1 ->
                Glide.with(it1)
                    .load(it.thumbnailUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(imageView)
            }

            val instructionsView = view.findViewById<TextView>(R.id.detailInstructionView)
            instructionsView.text = ""

            var instructionCounter = 0
            for (instruction: InstructionModel in it.instruction) {
                Log.d(TAG, "Instruction: ${instruction}")

                val minutes = (instruction.time.endTime - instruction.time.startTime) / 60 / 60

                instructionsView.append("Step ${instructionCounter + 1}:\n\n${instruction.displayText}\n\n")

                if (minutes > 0) {
                    instructionsView.append("Time: $minutes minutes.\n\n")
                }

                if (instructionCounter != it.instruction.size - 1) {
                    instructionsView.append("--------------------\n\n")
                }

                instructionCounter += 1
            }

            val webView = view.findViewById<android.webkit.WebView>(R.id.videoWebView)
            it.originalVideoUrl?.let { it1 -> webView.loadUrl(it1) }

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }
}