package nickNetology

data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "null",
    val canEdit: Boolean = false,
    val canDelete: Boolean = false,
    val friendsOnly: Boolean = true,
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
)
