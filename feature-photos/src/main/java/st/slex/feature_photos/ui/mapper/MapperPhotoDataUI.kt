package st.slex.feature_photos.ui.mapper

import st.slex.feature_photos.core.Mapper
import st.slex.feature_photos.data.model.PhotoDataModel
import st.slex.feature_photos.ui.model.PhotoUIModel
import javax.inject.Inject

interface MapperPhotoDataUI : Mapper<PhotoDataModel, PhotoUIModel> {

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