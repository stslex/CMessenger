package st.slex.core_model.ui

data class SearchPhotoUIModel(
    val total: Int,
    val total_pages: Int,
    val results: List<PhotoUIModel>
)