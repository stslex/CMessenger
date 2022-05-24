package st.slex.core_common

interface ValueData<out T> {

    interface Data<out T> : ValueData<T> {
        fun <U> map(mapper: Mapper.Data<T, U>): U
    }

    interface Domain<out T> : ValueData<T> {
        fun <U> map(mapper: Mapper.Domain<T, U>): U
    }

    interface UI<out T> : ValueData<T> {
        fun <U> map(mapper: Mapper.UI<T, U>): U
    }
}