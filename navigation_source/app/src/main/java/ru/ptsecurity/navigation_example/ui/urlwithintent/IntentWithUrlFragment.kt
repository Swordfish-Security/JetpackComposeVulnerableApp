package ru.ptsecurity.navigation_example.ui.urlwithintent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentIntentWithUrlBinding
import ru.ptsecurity.navigation_example.databinding.FragmentWebviewBinding

open class IntentWithUrlFragment : Fragment(R.layout.fragment_intent_with_url) {

    private val binding by viewBinding(FragmentIntentWithUrlBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: IntentWithUrlFragmentArgs by navArgs()
        if (safeArgs.url.isNotEmpty()) {
            Glide.with(requireContext())
                .load(safeArgs.url)
                .centerCrop()
                .into(binding.addedImageIv)
        }
    }
}