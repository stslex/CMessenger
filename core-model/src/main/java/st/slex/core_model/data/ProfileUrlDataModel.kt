package st.slex.core_model.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileUrlDataModel(
    @SerialName("small") val small: String = "",
    @SerialName("medium") val medium: String = "",
    @SerialName("large") val large: String = ""
)
