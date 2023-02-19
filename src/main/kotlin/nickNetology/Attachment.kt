package nickNetology

sealed class Attachment(val type: String)

class Graffiti() : Attachment("Graffiti") {
    class GraffitiAttachment() : Attachment("Graffiti") {
        val id = null
        val ownerId = null
        val artist = null
        val title = null
        val duration = null
        val url = null
        val lyricsId = null
        val albumId = null
        val genreId = null
        val date = null
        val noSearch = null
        val photo_130 = null
        val photo_604 = null
        val caption = null
        val description = null
        val isExternal = null
        val previewPage = null
        val previewUrl = null
        val groupId = null
        val creatorId = null
        val whoCanView = null
        val whoCanEdit = null
        val edited = null
        val created = null
        val editorId = null
        val views = null
        val parent = null
        val parent2 = null
        val source = null
        val html = null
        val currentUserCanEdit = null
        val currentUserCanEditAccess = null
    }
}

class Link() : Attachment("Link") {
    class LinkAttachment() : Attachment("Link") {
        val title = null
        val url = null
        val caption = null
        val description = null
        val isExternal = null
        val previewPage = null
        val previewUrl = null
    }
}

class WikiPage() : Attachment("WikiPage") {
    class WikiPageAttachment() : Attachment("WikiPage") {
        val id = null
        val title = null
        val groupId = null
        val creatorId = null
        val whoCanView = null
        val whoCanEdit = null
        val edited = null
        val created = null
        val editorId = null
        val views = null
        val parent = null
        val parent2 = null
        val source = null
        val html = null
        val viewUrl = null
        val currentUserCanEdit = null
        val currentUserCanEditAccess = null
    }
}

class MarketItem() : Attachment("MarketItem") {
    class MarketItemAttachment() : Attachment("MarketItem") {
        val id = null
        val ownerId = null
        val title = null
        val date = null
        val description = null
    }
}

class Sticker() : Attachment("Sticker") {
    class StickerAttachment() : Attachment("Sticker") {
        val id = null
        val title = null
        val groupId = null
        val creatorId = null
        val whoCanView = null
        val whoCanEdit = null
        val edited = null
        val created = null
        val editorId = null
        val views = null
        val parent = null
        val parent2 = null
        val source = null
        val html = null
        val viewUrl = null
        val currentUserCanEdit = null
        val currentUserCanEditAccess = null
    }
}