package st.slex.core_common

sealed class ValueState<out T> : ValueData.UI<T> {

    data class Success<T>(val data: T) : ValueState<T>() {
        override fun <U> map(mapper: Mapper.UI<T, U>): U = mapper.map(data)
    }

    data class Failure(val exception: Exception) : ValueState<Nothing>() {
        override fun <U> map(mapper: Mapper.UI<Nothing, U>): U = mapper.map(exception)
    }

    object Loading : ValueState<Nothing>() {
        override fun <U> map(mapper: Mapper.UI<Nothing, U>): U = mapper.map()
    }
}