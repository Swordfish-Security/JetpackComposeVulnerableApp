package ru.ptsecurity.navigation_example.ui.inner

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentShowInfoBinding
import ru.ptsecurity.navigation_example.databinding.FragmentWriteToFileBinding


open class InnerFragment : Fragment(R.layout.fragment_inner) {

    private val binding by viewBinding(FragmentShowInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: InnerFragmentArgs by navArgs()
        if (safeArgs.info.isNotEmpty()) {
            binding.infoFromIntentTv.text = safeArgs.info
        }
    }
}