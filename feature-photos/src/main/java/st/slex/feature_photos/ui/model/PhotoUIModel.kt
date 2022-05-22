package st.slex.feature_photos.ui.model

data class PhotoUIModel(
    val id: String,
    val created_at: String,
    val updated_at: String,
    val likes: Int,
    val user: UserUIModel?,
    val urls: PhotoUrlUIModel
)