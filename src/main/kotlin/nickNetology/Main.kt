package nickNetology

fun main() {
    val post1 = Post()
    val post2 = Post(text = "text for future updation")
    val post3 = Post()
    WallService.add(post1)//id=1
    WallService.add(post2)//id=2
    WallService.add(post3)//id=3
    WallService.print()
    println()
    WallService.update(Post(id = 2, text = "text updation"))// Обновил пост с id=2
    WallService.print()
}