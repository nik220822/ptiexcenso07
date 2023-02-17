package nickNetology

object WallService {
    private var posts = emptyArray<Post>()
    private var lastPostId: Int = 0

    fun clear() {
        posts = emptyArray()
        lastPostId = 0// также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastPostId, likes = post.likes?.copy(), reposts = post.reposts?.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((id, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[id] = newPost.copy(likes = newPost.likes?.copy(), reposts = newPost.reposts?.copy())
                return true
            }
        }
        return false
    }

    fun print() {
        for (post in posts) {
            println(post)
        }
    }
}