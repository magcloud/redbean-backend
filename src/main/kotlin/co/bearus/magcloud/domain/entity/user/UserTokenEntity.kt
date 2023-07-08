package co.bearus.magcloud.domain.entity.user

import co.bearus.magcloud.domain.entity.BaseAuditEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.io.Serializable

@Entity(name = "user_token")
class UserTokenEntity private constructor(
    @Id
    @Column
    val userId: String,

    @Id
    @Column(name = "refresh_token")
    var refreshToken: String,
) : Serializable, BaseAuditEntity() {
    companion object {
        fun createNewToken(userId: String, refreshToken: String) = UserTokenEntity(
            userId = userId,
            refreshToken = refreshToken,
        )
    }
}
