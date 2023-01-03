package hackathon.redbeanbackend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "user_tags")
data class UserTagEntity(
    @Id @ManyToOne @JoinColumn(name = "tag_id") var tagId: TagEntity? = null,
    @Id @ManyToOne @JoinColumn(name = "user_id") var user: UserEntity? = null,
) {
    //  constructor() : this(null, null)
    //constructor(tagId: TagEntity, user: UserEntity) : this(tagId, user)
}
