package st.slex.feature_photos.ui.model

data class UserUIModel(
    val id: String,
    val username: String,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileUrlUIModel
)
