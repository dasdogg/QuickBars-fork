package dev.trooped.tvquickbars.notification

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest

/** Zeigt ein (auch animiertes) Bild mit Durchsichtigkeit ueber den ganzen Bildschirm. */
@Composable
fun VollbildOverlay(url: String?) {
    val ctx = LocalContext.current
    val lader = remember(ctx) {
        ImageLoader.Builder(ctx).components { add(ImageDecoderDecoder.Factory()) }.build()
    }
    AsyncImage(
        model = ImageRequest.Builder(ctx).data(url).crossfade(false).build(),
        imageLoader = lader,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}
