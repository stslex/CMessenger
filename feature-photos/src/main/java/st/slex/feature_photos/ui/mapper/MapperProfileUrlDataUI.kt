package st.slex.feature_photos.ui.mapper

import st.slex.feature_photos.core.Mapper
import st.slex.feature_photos.data.model.ProfileUrlDataModel
import st.slex.feature_photos.ui.model.ProfileUrlUIModel
import javax.inject.Inject

interface MapperProfileUrlDataUI : Mapper<ProfileUrlDataModel?, ProfileUrlUIModel> {

    class Base @Inject constructor() : MapperProfileUrlDataUI {
        override fun map(data: ProfileUrlDataModel?): ProfileUrlUIModel = ProfileUrlUIModel(
            small = data?.small ?: "",
            medium = data?.medium ?: "",
            large = data?.large ?: ""
        )
    }
}