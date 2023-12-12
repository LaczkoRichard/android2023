package com.tasty.recipesapp.repository.recipe.model

import com.tasty.recipesapp.repository.instruction.model.InstructionModel
data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val instruction: List<InstructionModel>,
    val thumbnailUrl: String? = "",
)