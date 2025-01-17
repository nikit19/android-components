/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.components.concept.engine.manifest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WebAppManifestParserTest {

    @Test
    fun `Parsing example manifest from MDN`() {
        val json = loadManifest("example_mdn.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("HackerWeb", manifest.name)
        assertEquals("HackerWeb", manifest.shortName)
        assertEquals(".", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.STANDALONE, manifest.display)
        assertEquals(0xFFF, manifest.backgroundColor)
        assertEquals("A simply readable Hacker News app.", manifest.description)
        assertEquals(WebAppManifest.TextDirection.AUTO, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.ANY, manifest.orientation)
        assertNull(manifest.scope)
        assertNull(manifest.themeColor)

        assertEquals(6, manifest.icons.size)

        assertEquals("images/touch/homescreen48.png", manifest.icons[0].src)
        assertEquals("images/touch/homescreen72.png", manifest.icons[1].src)
        assertEquals("images/touch/homescreen96.png", manifest.icons[2].src)
        assertEquals("images/touch/homescreen144.png", manifest.icons[3].src)
        assertEquals("images/touch/homescreen168.png", manifest.icons[4].src)
        assertEquals("images/touch/homescreen192.png", manifest.icons[5].src)

        assertEquals("image/png", manifest.icons[0].type)
        assertEquals("image/png", manifest.icons[1].type)
        assertEquals("image/png", manifest.icons[2].type)
        assertEquals("image/png", manifest.icons[3].type)
        assertEquals("image/png", manifest.icons[4].type)
        assertEquals("image/png", manifest.icons[5].type)

        assertEquals(1, manifest.icons[0].sizes.size)
        assertEquals(1, manifest.icons[1].sizes.size)
        assertEquals(1, manifest.icons[2].sizes.size)
        assertEquals(1, manifest.icons[3].sizes.size)
        assertEquals(1, manifest.icons[4].sizes.size)
        assertEquals(1, manifest.icons[5].sizes.size)

        assertEquals(48, manifest.icons[0].sizes[0].width)
        assertEquals(72, manifest.icons[1].sizes[0].width)
        assertEquals(96, manifest.icons[2].sizes[0].width)
        assertEquals(144, manifest.icons[3].sizes[0].width)
        assertEquals(168, manifest.icons[4].sizes[0].width)
        assertEquals(192, manifest.icons[5].sizes[0].width)

        assertEquals(48, manifest.icons[0].sizes[0].height)
        assertEquals(72, manifest.icons[1].sizes[0].height)
        assertEquals(96, manifest.icons[2].sizes[0].height)
        assertEquals(144, manifest.icons[3].sizes[0].height)
        assertEquals(168, manifest.icons[4].sizes[0].height)
        assertEquals(192, manifest.icons[5].sizes[0].height)

        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[0].purpose)
        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[1].purpose)
        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[2].purpose)
        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[3].purpose)
        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[4].purpose)
        assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), manifest.icons[5].purpose)
    }

    @Test
    fun `Parsing example manifest from Google`() {
        val json = loadManifest("example_google.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("Google Maps", manifest.name)
        assertEquals("Maps", manifest.shortName)
        assertEquals("/maps/?source=pwa", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.STANDALONE, manifest.display)
        assertEquals(0x3367D6, manifest.backgroundColor)
        assertNull(manifest.description)
        assertEquals(WebAppManifest.TextDirection.AUTO, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.ANY, manifest.orientation)
        assertEquals("/maps/", manifest.scope)
        assertEquals(0x3367D6, manifest.themeColor)

        assertEquals(2, manifest.icons.size)

        manifest.icons[0].apply {
            assertEquals("/images/icons-192.png", src)
            assertEquals("image/png", type)
            assertEquals(1, sizes.size)
            assertEquals(192, sizes[0].width)
            assertEquals(192, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }

        manifest.icons[1].apply {
            assertEquals("/images/icons-512.png", src)
            assertEquals("image/png", type)
            assertEquals(1, sizes.size)
            assertEquals(512, sizes[0].width)
            assertEquals(512, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }
    }

    @Test
    fun `Parsing twitter mobile manifest`() {
        val json = loadManifest("twitter_mobile.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("Twitter", manifest.name)
        assertEquals("Twitter", manifest.shortName)
        assertEquals("/", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.STANDALONE, manifest.display)
        assertEquals(0xFFFFFF, manifest.backgroundColor)
        assertEquals("It's what's happening. From breaking news and entertainment, sports and politics, " +
            "to big events and everyday interests.", manifest.description)
        assertEquals(WebAppManifest.TextDirection.AUTO, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.ANY, manifest.orientation)
        assertEquals("/", manifest.scope)
        assertEquals(0xFFFFFF, manifest.themeColor)

        assertEquals(2, manifest.icons.size)

        manifest.icons[0].apply {
            assertEquals("https://abs.twimg.com/responsive-web/web/icon-default.604e2486a34a2f6e1.png", src)
            assertEquals("image/png", type)
            assertEquals(1, sizes.size)
            assertEquals(192, sizes[0].width)
            assertEquals(192, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }

        manifest.icons[1].apply {
            assertEquals("https://abs.twimg.com/responsive-web/web/icon-default.604e2486a34a2f6e1.png", src)
            assertEquals("image/png", type)
            assertEquals(1, sizes.size)
            assertEquals(512, sizes[0].width)
            assertEquals(512, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }
    }

    @Test
    fun `Parsing minimal manifest`() {
        val json = loadManifest("minimal.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("Minimal", manifest.name)
        assertNull(manifest.shortName)
        assertEquals("/", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.BROWSER, manifest.display)
        assertNull(manifest.backgroundColor)
        assertNull(manifest.description)
        assertEquals(WebAppManifest.TextDirection.AUTO, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.ANY, manifest.orientation)
        assertNull(manifest.scope)
        assertNull(manifest.themeColor)

        assertEquals(0, manifest.icons.size)
    }

    @Test
    fun `Parsing manifest with no name`() {
        val json = loadManifest("minimal_short_name.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("Minimal with Short Name", manifest.name)
        assertEquals("Minimal with Short Name", manifest.shortName)
        assertEquals("/", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.BROWSER, manifest.display)
        assertNull(manifest.backgroundColor)
        assertNull(manifest.description)
        assertEquals(WebAppManifest.TextDirection.AUTO, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.ANY, manifest.orientation)
        assertNull(manifest.scope)
        assertNull(manifest.themeColor)

        assertEquals(0, manifest.icons.size)
    }

    @Test
    fun `Parsing typical manifest from W3 spec`() {
        val json = loadManifest("spec_typical.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("Super Racer 3000", manifest.name)
        assertEquals("Racer3K", manifest.shortName)
        assertEquals("/racer/start.html", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.FULLSCREEN, manifest.display)
        assertEquals(0xFF0000, manifest.backgroundColor)
        assertEquals("The ultimate futuristic racing game from the future!", manifest.description)
        assertEquals(WebAppManifest.TextDirection.LTR, manifest.dir)
        assertEquals("en", manifest.lang)
        assertEquals(WebAppManifest.Orientation.LANDSCAPE, manifest.orientation)
        assertEquals("/racer/", manifest.scope)
        assertEquals(0xF0F8FF, manifest.themeColor)

        assertEquals(3, manifest.icons.size)

        manifest.icons[0].apply {
            assertEquals("icon/lowres.webp", src)
            assertEquals("image/webp", type)
            assertEquals(1, sizes.size)
            assertEquals(64, sizes[0].width)
            assertEquals(64, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }

        manifest.icons[1].apply {
            assertEquals("icon/lowres.png", src)
            assertNull(type)
            assertEquals(1, sizes.size)
            assertEquals(64, sizes[0].width)
            assertEquals(64, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }

        manifest.icons[2].apply {
            assertEquals("icon/hd_hi", src)
            assertNull(type)
            assertEquals(1, sizes.size)
            assertEquals(128, sizes[0].width)
            assertEquals(128, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.ANY), purpose)
        }
    }

    @Test
    fun `Parsing invalid JSON`() {
        val json = loadManifest("invalid_json.json")
        val result = WebAppManifestParser().parse(json)

        assertTrue(result is WebAppManifestParser.Result.Failure)
    }

    @Test
    fun `Parsing invalid JSON missing name fields`() {
        val json = loadManifest("invalid_missing_name.json")
        val result = WebAppManifestParser().parse(json)

        assertTrue(result is WebAppManifestParser.Result.Failure)
    }

    @Test
    fun `Parsing manifest with unusual values`() {
        val json = loadManifest("unusual.json")
        val result = WebAppManifestParser().parse(json)
        assertTrue(result is WebAppManifestParser.Result.Success)
        val manifest = (result as WebAppManifestParser.Result.Success).manifest

        assertNotNull(manifest)
        assertEquals("The Sample Manifest", manifest.name)
        assertEquals("Sample", manifest.shortName)
        assertEquals("/start", manifest.startUrl)
        assertEquals(WebAppManifest.DisplayMode.MINIMAL_UI, manifest.display)
        assertNull(manifest.backgroundColor)
        assertNull(manifest.description)
        assertEquals(WebAppManifest.TextDirection.RTL, manifest.dir)
        assertNull(manifest.lang)
        assertEquals(WebAppManifest.Orientation.PORTRAIT, manifest.orientation)
        assertEquals("/", manifest.scope)
        assertNull(manifest.themeColor)

        assertEquals(2, manifest.icons.size)

        manifest.icons[0].apply {
            assertEquals("/images/icon/favicon.ico", src)
            assertEquals("image/png", type)
            assertEquals(3, sizes.size)
            assertEquals(48, sizes[0].width)
            assertEquals(48, sizes[0].height)
            assertEquals(96, sizes[1].width)
            assertEquals(96, sizes[1].height)
            assertEquals(128, sizes[2].width)
            assertEquals(128, sizes[2].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.BADGE), purpose)
        }

        manifest.icons[1].apply {
            assertEquals("/images/icon/512-512.png", src)
            assertEquals("image/png", type)
            assertEquals(1, sizes.size)
            assertEquals("image/png", type)
            assertEquals(512, sizes[0].width)
            assertEquals(512, sizes[0].height)
            assertEquals(setOf(WebAppManifest.Icon.Purpose.MASKABLE, WebAppManifest.Icon.Purpose.ANY), purpose)
        }
    }

    private fun loadManifest(fileName: String): JSONObject =
        JSONObject(javaClass.getResourceAsStream("/manifests/$fileName")!!
            .bufferedReader().use {
                it.readText()
            }.also {
                assertNotNull(it)
            }
        )
}
