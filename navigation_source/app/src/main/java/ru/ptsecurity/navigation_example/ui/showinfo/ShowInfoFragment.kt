package ru.ptsecurity.navigation_example.ui.showinfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentShowInfoBinding

open class ShowInfoFragment : Fragment(R.layout.fragment_show_info) {

    private val binding by viewBinding(FragmentShowInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: ShowInfoFragmentArgs by navArgs()
        if (safeArgs.info.isNotEmpty()){
            binding.infoFromIntentTv.text = safeArgs.info
        }
    }
}