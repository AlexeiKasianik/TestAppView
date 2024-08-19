package itexus.com.testview.uiKit

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

fun <T : Any?> Flow<T>.bind(
    lifecycleOwner: LifecycleOwner,
    onError: suspend (Throwable) -> Unit = {
        println(it.message)
    },
    onNext: suspend (T) -> Unit = {},
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
            catch { onError(it) }
                .collect(onNext)
        }
    }
}