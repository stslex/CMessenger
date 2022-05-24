package st.slex.core_model.mapper

import st.slex.core_common.Mapper
import st.slex.core_model.data.PhotoDataModel
import st.slex.core_model.ui.PhotoUIModel
import javax.inject.Inject

interface MapperPhotoDataUI : Mapper.Data<PhotoDataModel, PhotoUIModel> {

    class Base @Inject constructor(
        private val userMapper: MapperUserDataUI,
        private val urlsMapper: MapperPhotoUrlsDataUI
    ) : MapperPhotoDataUI {

        override fun map(data: PhotoDataModel): PhotoUIModel = with(data) {
            PhotoUIModel(
                id = id,
                created_at = created_at,
                updated_at = updated_at,
                likes = likes,
                user = userMapper.map(user),
                urls = urlsMapper.map(urls)
            )
        }
    }
}