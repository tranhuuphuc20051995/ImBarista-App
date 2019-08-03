package com.alexzh.data.mapper

import com.alexzh.data.model.AuthUserEntity
import com.alexzh.imbarista.domain.model.AuthUser

class AuthUserMapper : EntityMapper<AuthUserEntity, AuthUser> {

    override fun mapFromEntity(entity: AuthUserEntity): AuthUser {
        return AuthUser(
            entity.id,
            entity.name,
            entity.token
        )
    }

    override fun mapToEntity(domainModel: AuthUser): AuthUserEntity {
        return AuthUserEntity(
            domainModel.id,
            domainModel.name,
            domainModel.token
        )
    }
}