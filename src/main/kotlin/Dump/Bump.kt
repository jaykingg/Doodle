package Dump

import java.time.Instant

data class Bump(
    val id: Long,

    val createdAt: Instant,

    val userId: String,

    var targetUserId: String,

    val bumpLocation: LocationRecord,

    /*
        createdAt 기준, 24 시간 이후 false 처리
     */
    val enable: Boolean
)