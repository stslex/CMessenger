package st.slex.feature_photos.data.model

import kotlinx.serialization.SerialName

class PhotoUrlDataModel(
    @SerialName("raw") val raw: String = "",
    @SerialName("full") val full: String = "",
    @SerialName("regular") val regular: String = "",
    @SerialName("small") val small: String = "",
    @SerialName("thumb") val thumb: String = ""
)