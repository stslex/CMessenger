package st.slex.feature_photos.ui.mapper

import st.slex.feature_photos.core.Mapper
import st.slex.feature_photos.data.model.UserDataModel
import st.slex.feature_photos.ui.model.UserUIModel
import javax.inject.Inject

interface MapperUserDataUI : Mapper<UserDataModel?, UserUIModel> {

    class Base @Inject constructor(
        private val profileMapper: MapperProfileUrlDataUI
    ) : MapperUserDataUI {
        override fun map(data: UserDataModel?): UserUIModel = UserUIModel(
            id = data?.id ?: "",
            username = data?.username ?: "",
            name = data?.name ?: "",
            portfolio_url = data?.portfolio_url ?: "",
            profile_image = profileMapper.map(data?.profile_image)
        )
    }
}