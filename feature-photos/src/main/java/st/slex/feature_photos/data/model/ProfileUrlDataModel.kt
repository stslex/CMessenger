package st.slex.feature_photos.data.model

import kotlinx.serialization.SerialName

data class ProfileUrlDataModel(
    @SerialName("small") val small: String = "",
    @SerialName("medium") val medium: String = "",
    @SerialName("large") val large: String = ""
)
