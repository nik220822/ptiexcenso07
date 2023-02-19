package nickNetology

open class Attachment(
    val type: String? = null,
    open val id: Int? = null,
    open val ownerId: Int? = null,
    open val artist: String? = null,
    open val title: String? = null,
    open val duration: Int? = null,
    open val url: String? = null,
    open val lyricsId: Int? = null,
    open val albumId: Int? = null,
    open val genreId: Int? = null,
    open val date: Int? = null,
    open val noSearch: Boolean? = null,
    open val photo_130: String? = null,
    open val photo_604: String? = null,
    open val caption: String? = null,
    open val description: String? = null,
    open val isExternal: Int? = null,
    open val previewPage: Nothing? = null,
    open val previewUrl: String? = null,
    open val groupId: Int? = null,
    open val creatorId: Int? = null,
    open val whoCanView: Int? = null,
    open val whoCanEdit: Int? = null,
    open val edited: Int? = null,
    open val created: Int? = null,
    open val editorId: Int? = null,
    open val views: Int? = null,
    open val parent: String? = null,
    open val parent2: String? = null,
    open val source: String? = null,
    open val html: String? = null,
    open val viewUrl: String? = null,
    open val currentUserCanEdit: Int? = null,
    open val currentUserCanEditAccess: Int? = null
)

class Graffiti() : Attachment(type = "Graffiti") {
    class GraffitiAttachment() : Attachment(type = "Graffiti") {
        override val id = null
        override val ownerId = null
        override val artist = null
        override val title = null
        override val duration = null
        override val url = null
        override val lyricsId = null
        override val albumId = null
        override val genreId = null
        override val date = null
        override val noSearch = null
        override val photo_130 = null
        override val photo_604 = null
        override val caption = null
        override val description = null
        override val isExternal = null
        override val previewPage = null
        override val previewUrl = null
        override val groupId = null
        override val creatorId = null
        override val whoCanView = null
        override val whoCanEdit = null
        override val edited = null
        override val created = null
        override val editorId = null
        override val views = null
        override val parent = null
        override val parent2 = null
        override val source = null
        override val html = null
        override val currentUserCanEdit = null
        override val currentUserCanEditAccess = null
    }
}

class Link() : Attachment(type = "Link") {
    class LinkAttachment() : Attachment(type = "Link") {
        override val title = null
        override val url = null
        override val caption = null
        override val description = null
        override val isExternal = null
        override val previewPage = null
        override val previewUrl = null
    }
}

class WikiPage() : Attachment(type = "WikiPage") {
    class WikiPageAttachment() : Attachment(type = "WikiPage") {
        override val id = null
        override val title = null
        override val groupId = null
        override val creatorId = null
        override val whoCanView = null
        override val whoCanEdit = null
        override val edited = null
        override val created = null
        override val editorId = null
        override val views = null
        override val parent = null
        override val parent2 = null
        override val source = null
        override val html = null
        override val viewUrl = null
        override val currentUserCanEdit = null
        override val currentUserCanEditAccess = null
    }
}

class MarketItem() : Attachment(type = "MarketItem") {
    class MarketItemAttachment() : Attachment(type = "MarketItem") {
        override val id = null
        override val ownerId = null
        override val title = null
        override val date = null
        override val description = null
    }
}

class Sticker() : Attachment(type = "Sticker") {
    class StickerAttachment() : Attachment(type = "Sticker") {
        override val id = null
        override val title = null
        override val groupId = null
        override val creatorId = null
        override val whoCanView = null
        override val whoCanEdit = null
        override val edited = null
        override val created = null
        override val editorId = null
        override val views = null
        override val parent = null
        override val parent2 = null
        override val source = null
        override val html = null
        override val viewUrl = null
        override val currentUserCanEdit = null
        override val currentUserCanEditAccess = null
    }
}