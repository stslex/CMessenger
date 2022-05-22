package st.slex.feature_photos.data.model

import kotlinx.serialization.SerialName

data class UserDataModel(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("portfolio_url") val portfolio_url: String = "",
    @SerialName("profile_image") val profile_image: ProfileUrlDataModel
)
