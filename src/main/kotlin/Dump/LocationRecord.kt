package Dump

import java.time.Instant

data class LocationRecord(
    val id: Long,

    val userId: String,

    val createdAt: Instant,

    /*
        위도
     */
    val latitude: Double,

    /*
        경도
     */
    val longitude: Double,

    /*
        활성화/비활성화 여부 24 시간 이후 false 처리
        24시간 이후지만 데이터는 보관되어야한다(?)
     */
    val enable: Boolean

)