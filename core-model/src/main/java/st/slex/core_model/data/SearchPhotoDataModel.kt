package st.slex.core_model.data

import kotlinx.serialization.SerialName

data class SearchPhotoDataModel(
    @SerialName("total") val total: Int? = 0,
    @SerialName("total_pages") val total_pages: Int? = 0,
    @SerialName("results") val results: List<PhotoDataModel>
)