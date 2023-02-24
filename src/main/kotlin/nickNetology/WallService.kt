package nickNetology

object WallService {
    var posts = emptyArray<Post>()
    private var lastPostId: Int = 0
    var comments = emptyArray<Comment>()
    private var lastCommentId: Int = 0
    var reportComments = emptyArray<Comment>()
    private var lastReportCommentId: Int = 0

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        reportComments = emptyArray()
        lastPostId = 0// также здесь нужно сбросить счетчик для id постов, если он у вас используется
        lastCommentId = 0
        lastReportCommentId = 0
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
            for (comment in comments) {
                if (post.id == comment.commentPostId) {
                    println(comment)
                    comment.print()
                }
            }
        }
    }

    fun printWithCommentsInPostVer2() { //другой вариант
        for (post in posts) {
            println(post)
            post.comments?.forEach { comment ->
                comment.print()
            }
        }
    }

    fun printWithCommentsInPost() {
        for (post in posts) {
            println(post)
            for (comment in post.comments!!) {
                comment.print()
//            post.comments?.get(1)?.print()
            }
        }
    }

    fun createCommentVer3(id: Int, comment: Comment): Comment? {//Непонятно, почему не работает
        for ((thisId, comments) in posts) {
            if (id == thisId) {
//                comments += comment
//                return comments.last()
            }
        }
        return throw PostNotFoundException("Post with id = $id was not found")
    }

    fun createCommentVer2(id: Int, comment: Comment): Comment? {
        if (foundById(id)) {
            posts[id - 1].comments = posts[id - 1].comments?.plus(comment)
//            posts[id-1].comments += comment//Непонятно почему так нельзя
            return posts[id - 1].comments?.last()
        }
        return throw PostNotFoundException("Post with id = $id was not found")
    }

    fun createComment(commentPostId: Int, comment: Comment): Comment {
        comment.commentPostId = commentPostId
        if (foundById(commentPostId)) {
            comments += comment.copy(id = ++lastCommentId)
            return comments.last()
        } else throw PostNotFoundException("Post with id = $commentPostId was not found")
    }

    fun foundById(commentPostId: Int): Boolean {
        for (post in posts) {
            if (post.id == commentPostId) {
                return true
            }
        }
        return false
    }

    fun reportComment(id: Int, reason: Int): Int {
        if (foundCommentById(id)) {
            addReportComment(id)
            when (reason) {
                0 -> {
                    println("в комменте $id спам")
                    return 1
                }

                1 -> {
                    println("в комменте $id детская порнография")
                    return 1
                }

                2 -> {
                    println("в комменте $id экстремизм")
                    return 1
                }

                3 -> {
                    println("в комменте $id насилие")
                    return 1
                }

                4 -> {
                    println("в комменте $id пропаганда наркотиков")
                    return 1
                }

                5 -> {
                    println("в комменте $id материал для взрослых")
                    return 1
                }

                6 -> {
                    println("в комменте $id оскорбление")
                    return 1
                }

                7 -> {
                    println("в комменте $id призывы к суициду")
                    return 1
                }

                else -> {
                    throw NotCorrectReason("the given reason ($reason) is incorrect")
                }
            }
        }
        return throw CommentNotFoundException("Comment with id = $id was not found")
    }

    fun foundCommentById(commentId: Int): Boolean {
        for (comment in comments) {
            if (comment.id == commentId) {
                return true
            }
        }
        return false
    }

    fun addReportComment(commentId: Int): Comment {
        val comment = comments[commentId - 1]
        reportComments += comment.copy(id = ++lastReportCommentId)
        return reportComments.last()
    }
}