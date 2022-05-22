package st.slex.feature_photos.ui.mapper

import st.slex.feature_photos.core.Mapper
import st.slex.feature_photos.data.model.PhotoUrlDataModel
import st.slex.feature_photos.ui.model.PhotoUrlUIModel
import javax.inject.Inject

interface MapperPhotoUrlsDataUI : Mapper<PhotoUrlDataModel, PhotoUrlUIModel> {

    class Base @Inject constructor() : MapperPhotoUrlsDataUI {

        override fun map(data: PhotoUrlDataModel): PhotoUrlUIModel = with(data) {
            PhotoUrlUIModel(raw = raw, full = full, regular = regular, small = small, thumb = thumb)
        }
    }
}