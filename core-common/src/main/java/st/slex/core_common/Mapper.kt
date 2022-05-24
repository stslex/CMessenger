package st.slex.core_common

interface Mapper<in T, out U> {

    interface Data<in T, out U> : Mapper<T, U> {
        fun map(data: T): U
    }

    interface Domain<in T, out U> : Data<T, U> {
        fun map(exception: Exception): U
    }

    interface UI<in T, out U> : Domain<T, U> {
        fun map(): U
    }
}