import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GreetingTest : FreeSpec({
    val androidPlatform = object : Platform {
        override val name: String = "Android"
    }
    "should greet me with Android platform" - {
        val greeting = Greeting(androidPlatform)
        greeting.greet() shouldBe "Hello, Android!"
    }
})