package st.slex.core_model.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDataModel(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("portfolio_url") val portfolio_url: String = "",
    @SerialName("profile_image") val profile_image: ProfileUrlDataModel
)
