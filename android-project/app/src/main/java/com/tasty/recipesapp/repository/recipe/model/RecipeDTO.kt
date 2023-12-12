package com.tasty.recipesapp.repository.recipe.model

import com.tasty.recipesapp.repository.instruction.model.InstructionDTO
import com.tasty.recipesapp.repository.instruction.model.toModelList
import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val instructions: List<InstructionDTO>,

    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = "",
)

fun RecipeDTO.toModel(): RecipeModel =
    RecipeModel (
        id = this.id,
        name = this.name,
        description = this.description,
        instruction = this.instructions.toModelList(),
        thumbnailUrl = this.thumbnailUrl,
    )

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }