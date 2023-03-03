import junit.framework.Assert.assertEquals
import nickNetology.*
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class Tests {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun revisionOK() {
        val post1 = Post()
        val post2 = Post(text = "text for future updation")
        val post3 = Post()
        val result: Comment
        WallService.add(post1)//id=1
        WallService.add(post2)//id=2
        WallService.add(post3)//id=3
        val theCommentPostId = 1
        val comment = Comment(theCommentPostId)
        if (WallService.foundById(theCommentPostId)) {
            WallService.comments += comment.copy(id = ++WallService.lastCommentId)
            result = WallService.comments.last()
        } else throw PostNotFoundException("Post with id = $theCommentPostId was not found")
        assertEquals(comment, result)
    }
    @Test(expected = PostNotFoundException::class)
    fun revisionNotOK() {
        val post1 = Post()
        val post2 = Post(text = "text for future updation")
        val post3 = Post()
        WallService.add(post1)//id=1
        WallService.add(post2)//id=2
        WallService.add(post3)//id=3
        val theCommentPostId = 4
        val comment = Comment(theCommentPostId)
        if (WallService.foundById(theCommentPostId)) {
            WallService.comments += comment.copy(id = ++WallService.lastCommentId)
        } else throw PostNotFoundException("Post with id = $theCommentPostId was not found")
    }
    @Test
    fun testAdd() {
        val result = WallService.add(Post()).id
        assertNotEquals(0, result)
    }

    @Test
    fun testUpdateIfReturnTrue() {
        val post1 = Post()
        WallService.add(post1)
        val result = WallService.update(Post(id = 1))
        assertEquals(true, result)
    }

    @Test
    fun testUpdateIfReturnFalse() {
        val post1 = Post()
        WallService.add(post1)
        val result = WallService.update(Post(id = 2))
        assertEquals(false, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val commentPostId = 2
        val comment = Comment(commentPostId = commentPostId)
        val post1 = Post()
        WallService.add(post1)
        if (WallService.foundById(commentPostId)) {
            WallService.comments += comment
        } else throw PostNotFoundException("Post with id = $commentPostId was not found")
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
    }

    @Test
    fun shouldReturnComment() {
        val commentPostId = 1
        val comment = Comment(commentPostId = commentPostId)
        val post1 = Post()
        WallService.add(post1)
        if (WallService.foundById(commentPostId)) {
            WallService.comments += comment
        } else throw PostNotFoundException("Post with id = $commentPostId was not found")
        assertEquals(comment, WallService.comments.last())
    }

    @Test(expected = NotCorrectReason::class)
    fun reportCommentThrowReasonIncorrect() {
        val id = 1
        val reason = 9
        val post1 = Post()
        WallService.add(post1)
        WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))
        if (WallService.foundCommentById(id)) {
            WallService.addReportComment(id)
            when (reason) {
                0 -> {
                    println("в комменте $id спам")
                }

                1 -> {
                    println("в комменте $id детская порнография")
                }

                2 -> {
                    println("в комменте $id экстремизм")
                }

                3 -> {
                    println("в комменте $id насилие")
                }

                4 -> {
                    println("в комменте $id пропаганда наркотиков")
                }

                5 -> {
                    println("в комменте $id материал для взрослых")
                }

                6 -> {
                    println("в комменте $id оскорбление")
                }

                7 -> {
                    println("в комменте $id призывы к суициду")
                }

                else -> {
                    throw NotCorrectReason("the given reason ($reason) is incorrect")
                }
            }
        }
    }

    @Test
    fun reportCommentReturnInt() {
        var result: Int = 0
        val id = 1
        val reason = 7
        val post1 = Post()
        WallService.add(post1)
        WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))
        if (WallService.foundCommentById(id)) {
            WallService.addReportComment(id)
            when (reason) {
                0 -> {
                    println("в комменте $id спам")
                    result = 1
                }

                1 -> {
                    println("в комменте $id детская порнография")
                    result = 1
                }

                2 -> {
                    println("в комменте $id экстремизм")
                    result = 1
                }

                3 -> {
                    println("в комменте $id насилие")
                    result = 1
                }

                4 -> {
                    println("в комменте $id пропаганда наркотиков")
                    result = 1
                }

                5 -> {
                    println("в комменте $id материал для взрослых")
                    result = 1
                }

                6 -> {
                    println("в комменте $id оскорбление")
                    result = 1
                }

                7 -> {
                    println("в комменте $id призывы к суициду")
                    result = 1
                }

                else -> {
                    throw NotCorrectReason("the given reason ($reason) is incorrect")
                }
            }
        }
        assertEquals(1, result)
    }
}