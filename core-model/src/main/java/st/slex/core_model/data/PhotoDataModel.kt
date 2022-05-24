package st.slex.core_model.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDataModel(
    @SerialName("id") val id: String,
    @SerialName("created_at") val created_at: String = "",
    @SerialName("updated_at") val updated_at: String = "",
    @SerialName("likes") val likes: Int = 0,
    @SerialName("user") val user: UserDataModel?,
    @SerialName("urls") val urls: PhotoUrlDataModel?
)