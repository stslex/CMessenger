package st.slex.core_model.mapper

import st.slex.core_model.Mapper
import st.slex.core_model.data.SearchPhotoDataModel
import st.slex.core_model.ui.SearchPhotoUIModel
import javax.inject.Inject

interface MapperSearchPhotoDataUI : Mapper<SearchPhotoDataModel, SearchPhotoUIModel> {

    class Base @Inject constructor(private val mapper: MapperPhotoDataUI) :
        MapperSearchPhotoDataUI {

        override fun map(data: SearchPhotoDataModel): SearchPhotoUIModel = SearchPhotoUIModel(
            total = data.total ?: 0,
            total_pages = data.total_pages ?: 0,
            results = data.results.map(mapper::map)
        )
    }
}