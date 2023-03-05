package nickNetology

fun main() {
    WallService.clear()
    val post1 = Post()
    val post2 = Post(text = "text for future updation")
    val post3 = Post()
    WallService.add(post1)//id=1
    WallService.add(post2)//id=2
    WallService.add(post3)//id=3
    WallService.createComment(commentPostId = 1, Comment(text = "text for comment for post 1"))//1
    WallService.createComment(commentPostId = 2, Comment(text = "text for comment for post 2"))//2
    WallService.createComment(commentPostId = 3, Comment(text = "text for comment for post 3"))//3
    WallService.createComment(commentPostId = 3, Comment(text = "text for comment for post 3; must be reported"))//4
    WallService.print()
    println()
    WallService.createReportComment(commentId=4,5)
    println(WallService.listOfReportComments)
}