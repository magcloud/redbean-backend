package co.bearus.magcloud.domain.repository

import co.bearus.magcloud.domain.entity.user.UserEntity
import co.bearus.magcloud.domain.type.LoginProvider
import org.springframework.data.jpa.repository.JpaRepository

interface JPAUserRepository : JpaRepository<UserEntity, String> {
    fun getByEmail(email: String): UserEntity?
    fun getByProviderAndEmail(provider: LoginProvider, email: String): UserEntity?
    fun getByProviderAndUserIdentifier(provider: LoginProvider, userIdentifier: String): UserEntity?
}
