[android-components](../../index.md) / [mozilla.components.browser.search](../index.md) / [SearchEngineManager](./index.md)

# SearchEngineManager

`class SearchEngineManager` [(source)](https://github.com/mozilla-mobile/android-components/blob/master/components/browser/search/src/main/java/mozilla/components/browser/search/SearchEngineManager.kt#L27)

This class provides access to a centralized registry of search engines.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SearchEngineManager(providers: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SearchEngineProvider`](../../mozilla.components.browser.search.provider/-search-engine-provider/index.md)`> = listOf(
            AssetsSearchEngineProvider(LocaleSearchLocalizationProvider())), coroutineContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)` = Dispatchers.Default)`<br>This class provides access to a centralized registry of search engines. |

### Properties

| Name | Summary |
|---|---|
| [defaultSearchEngine](default-search-engine.md) | `var defaultSearchEngine: `[`SearchEngine`](../-search-engine/index.md)`?`<br>This is set by browsers to indicate the users preference of which search engine to use. This overrides the default which may be set by the [SearchEngineProvider](../../mozilla.components.browser.search.provider/-search-engine-provider/index.md) (e.g. via `list.json`) |

### Functions

| Name | Summary |
|---|---|
| [getDefaultSearchEngine](get-default-search-engine.md) | `fun getDefaultSearchEngine(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = EMPTY): `[`SearchEngine`](../-search-engine/index.md)<br>Returns the default search engine. |
| [getProvidedDefaultSearchEngine](get-provided-default-search-engine.md) | `fun getProvidedDefaultSearchEngine(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`SearchEngine`](../-search-engine/index.md)<br>Returns the provided default search engine or the first search engine if the default is not set. |
| [getSearchEngines](get-search-engines.md) | `fun getSearchEngines(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SearchEngine`](../-search-engine/index.md)`>`<br>Returns all search engines. |
| [load](load.md) | `suspend fun ~~load~~(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): Deferred<`[`SearchEngineList`](../../mozilla.components.browser.search.provider/-search-engine-list/index.md)`>`<br>Asynchronously load search engines from providers. Inherits caller's [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html). |
| [loadAsync](load-async.md) | `suspend fun loadAsync(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): Deferred<`[`SearchEngineList`](../../mozilla.components.browser.search.provider/-search-engine-list/index.md)`>`<br>Asynchronously load search engines from providers. Inherits caller's [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html). |
| [registerForLocaleUpdates](register-for-locale-updates.md) | `fun registerForLocaleUpdates(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers for ACTION_LOCALE_CHANGED broadcasts and automatically reloads the search engines whenever the locale changes. |
