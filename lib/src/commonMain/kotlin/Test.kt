import kotlin.jvm.JvmInline

@JvmInline
value class Test(val key: Int) {
    constructor(a: String, b: String) : this(0)
}