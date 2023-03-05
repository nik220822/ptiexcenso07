package nickNetology

data class ReportComment(
    val id: Int? = null,
    val ownerId: Int? = null,
    val commentId: Int? = null,
    val reason: String? = null
)

data class Post(
    var id: Int = 0,
    var comments: Array<Comment>? = null,
    val text: String? = null,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = true,
    val copyright: String? = null,
    val likes: Likes? = Likes(),
    val reposts: Reposts? = Reposts(),
    val views: Any? = null,
    val postType: String? = null,
    val postSourse: Any? = null,
    val geo: Any? = null,
    val signerId: Int? = null,
    val copyHistory: Array<Post>? = null,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean? = null,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int? = null,
    val original: Post? = null,
    val attachments: Array<Attachment>? = null
)

data class Reposts(
    val userReposted: Boolean = false,
    val count: Int = 0
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false
)

data class Comment(
    val id: Int? = null,
    var commentPostId: Int? = null,
    val fromId: Int? = null,
    val date: Int? = null,
    val text: String? = null,
    val donut: Donut? = null,
    val replyToUser: Int? = null,
    val replyToComment: Int? = null,
    val attachments: Array<Attachment>? = null,
    val parentsStack: Array<ParentComment>? = null,
    val thread: CommentThread? = null//Обычная фред уже зарезервирована джавой
) {
    fun print() {
        println(text)
    }
}

class Donut(val isDon: Boolean, val placeholder: String)
class ParentComment()
class CommentThread(
    val count: Int,
    val items: Array<Item>,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)

class Item()
class PostNotFoundException(mess: String) : RuntimeException(mess)
class CommentNotFoundException(mess: String) : RuntimeException(mess)
class NotCorrectReason(mess: String) : RuntimeException(mess)

