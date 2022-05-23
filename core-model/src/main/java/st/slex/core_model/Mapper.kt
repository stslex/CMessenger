package st.slex.core_model

interface Mapper<in T, out U> {
    fun map(data: T): U
}