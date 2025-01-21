package ch.allink.sample_cmp_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform