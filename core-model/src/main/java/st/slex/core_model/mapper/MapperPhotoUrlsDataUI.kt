package st.slex.core_model.mapper

import st.slex.core_model.Mapper
import st.slex.core_model.data.PhotoUrlDataModel
import st.slex.core_model.ui.PhotoUrlUIModel
import javax.inject.Inject

interface MapperPhotoUrlsDataUI : Mapper<PhotoUrlDataModel, PhotoUrlUIModel> {

    class Base @Inject constructor() : MapperPhotoUrlsDataUI {

        override fun map(data: PhotoUrlDataModel): PhotoUrlUIModel = with(data) {
            PhotoUrlUIModel(raw = raw, full = full, regular = regular, small = small, thumb = thumb)
        }
    }
}