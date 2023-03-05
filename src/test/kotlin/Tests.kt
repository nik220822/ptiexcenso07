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
        WallService.createComment(theCommentPostId, comment)
        result = WallService.comments.last()
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
        WallService.createComment(theCommentPostId, comment)
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

    @Test(expected = CommentNotFoundException::class)
    fun reportCommentCommentNotFoundException() {
        val reason = 5
        val post1 = Post()
        WallService.add(post1)//id=1
        WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))//id=1
        WallService.createReportComment(commentId = 10, reason = reason)
    }

    @Test(expected = NotCorrectReason::class)
    fun reportCommentThrowReasonIncorrect() {
        val reason = 9
        val post1 = Post()
        WallService.add(post1)//id=1
        WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))//id=1
        WallService.createReportComment(commentId = 1, reason = reason)
    }

    @Test
    fun reportCommentOK() {
        val reason = 7
        val post1 = Post()
        WallService.add(post1)
        WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))
        var result = WallService.createReportComment(commentId = 1, reason = reason)
        assertEquals(1, result)
    }
}