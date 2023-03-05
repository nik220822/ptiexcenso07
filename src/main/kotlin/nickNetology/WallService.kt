package nickNetology

object WallService {
    var listOfReportComments = mutableListOf<ReportComment>()
    var posts = emptyArray<Post>()
    private var lastPostId: Int = 0
    var comments = emptyArray<Comment>()
    var lastCommentId: Int = 0
    private var lastReportCommentId: Int = 0

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        listOfReportComments = mutableListOf()//чищу мутаблЛист
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

    fun createReportComment(commentId: Int, reason: Int): Int {
        if (foundCommentById(commentId)) {
            val reportComment = ReportComment(id = ++lastReportCommentId, commentId = commentId)
            listOfReportComments.add(reportComment)
            when (reason) {
                0 -> {
                    println("в комменте $commentId спам")
                    return 1
                }

                1 -> {
                    println("в комменте $commentId детская порнография")
                    return 1
                }

                2 -> {
                    println("в комменте $commentId экстремизм")
                    return 1
                }

                3 -> {
                    println("в комменте $commentId насилие")
                    return 1
                }

                4 -> {
                    println("в комменте $commentId пропаганда наркотиков")
                    return 1
                }

                5 -> {
                    println("в комменте $commentId материал для взрослых")
                    return 1
                }

                6 -> {
                    println("в комменте $commentId оскорбление")
                    return 1
                }

                7 -> {
                    println("в комменте $commentId призывы к суициду")
                    return 1
                }

                else -> {
                    throw NotCorrectReason("the given reason ($reason) is incorrect")
                }
            }
        }
        return throw CommentNotFoundException("Comment with id = $commentId was not found")
    }

    fun foundCommentById(commentId: Int): Boolean {
        for (comment in comments) {
            if (comment.id == commentId) {
                return true
            }
        }
        return false
    }
}