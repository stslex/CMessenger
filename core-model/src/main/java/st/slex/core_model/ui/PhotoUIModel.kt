package st.slex.core_model.ui

data class PhotoUIModel(
    val id: String,
    val created_at: String,
    val updated_at: String,
    val likes: Int,
    val user: UserUIModel?,
    val urls: PhotoUrlUIModel
)