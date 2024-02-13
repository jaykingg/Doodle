package Dump

import java.net.URL

data class User(

    val userid: String,

    /*
        Instagram Id
     */
    val socialId: String,

    /*
        Instagram 에서 사용하는 사용자 명
     */
    val username: String,

    val profileImg: URL,

    val Introduction: String,

    /*
        24 시간 위치 데이터
     */
    val locationRecord: List<LocationRecord>,

    /*
        각 사용자에 대한 Bump List
     */
    val bumpList: List<Bump>

    /**
     *  기타 등등
     */
)