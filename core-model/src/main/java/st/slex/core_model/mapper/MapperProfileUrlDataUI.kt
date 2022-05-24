package st.slex.core_model.mapper

import st.slex.core_common.Mapper
import st.slex.core_model.data.ProfileUrlDataModel
import st.slex.core_model.ui.ProfileUrlUIModel
import javax.inject.Inject

interface MapperProfileUrlDataUI : Mapper.Data<ProfileUrlDataModel?, ProfileUrlUIModel> {

    class Base @Inject constructor() : MapperProfileUrlDataUI {
        override fun map(data: ProfileUrlDataModel?): ProfileUrlUIModel = ProfileUrlUIModel(
            small = data?.small ?: "",
            medium = data?.medium ?: "",
            large = data?.large ?: ""
        )
    }
}