package st.slex.core_model.mapper

import st.slex.core_common.Mapper
import st.slex.core_model.data.PhotoUrlDataModel
import st.slex.core_model.ui.PhotoUrlUIModel
import javax.inject.Inject

interface MapperPhotoUrlsDataUI : Mapper.Data<PhotoUrlDataModel?, PhotoUrlUIModel> {

    class Base @Inject constructor() : MapperPhotoUrlsDataUI {

        override fun map(data: PhotoUrlDataModel?): PhotoUrlUIModel = with(data) {
            PhotoUrlUIModel(
                raw = data?.raw ?: "",
                full = data?.full ?: "",
                regular = data?.regular ?: "",
                small = data?.small ?: "",
                thumb = data?.thumb ?: ""
            )
        }
    }
}