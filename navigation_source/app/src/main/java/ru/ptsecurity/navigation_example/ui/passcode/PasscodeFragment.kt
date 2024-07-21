package ru.ptsecurity.navigation_example.ui.passcode

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentPasscodeBinding

open class PasscodeFragment : Fragment(R.layout.fragment_passcode) {

    private val binding by viewBinding(FragmentPasscodeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.passcodeView.apply {
            setOnChangePasscodeListener { _, isCompleted, _ ->
                if (isCompleted) {
                    findNavController().navigate(R.id.navigation_home)
                }
            }
        }
    }
}