[android-components](../../index.md) / [mozilla.components.browser.search](../index.md) / [SearchEngineManager](index.md) / [registerForLocaleUpdates](./register-for-locale-updates.md)

# registerForLocaleUpdates

`fun registerForLocaleUpdates(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/mozilla-mobile/android-components/blob/master/components/browser/search/src/main/java/mozilla/components/browser/search/SearchEngineManager.kt#L116)

Registers for ACTION_LOCALE_CHANGED broadcasts and automatically reloads the search engines
whenever the locale changes.

