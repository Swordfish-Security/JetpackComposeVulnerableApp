package ru.ptsecurity.navigation_example.ui.webview

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentWebviewBinding

open class WebViewFragment : Fragment(R.layout.fragment_webview) {

    private val binding by viewBinding(FragmentWebviewBinding::bind)

    override fun onResume() {
        super.onResume()
        with(binding) {
            wv.run {
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.allowFileAccess = true
                settings.supportZoom()
                settings.builtInZoomControls = true
                val safeArgs: WebViewFragmentArgs by navArgs()
                if (safeArgs.url.isNotEmpty()) {
                    val u = safeArgs.url
                    loadUrl(u)
                }
            }
        }
    }
}