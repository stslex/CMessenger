package st.slex.feature_photos.core

interface Mapper<in T, out U> {
    fun map(data: T): U
}