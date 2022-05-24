package st.slex.core_model.mapper

import st.slex.core_common.Mapper
import st.slex.core_model.data.UserDataModel
import st.slex.core_model.ui.UserUIModel
import javax.inject.Inject

interface MapperUserDataUI : Mapper.Data<UserDataModel?, UserUIModel> {

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