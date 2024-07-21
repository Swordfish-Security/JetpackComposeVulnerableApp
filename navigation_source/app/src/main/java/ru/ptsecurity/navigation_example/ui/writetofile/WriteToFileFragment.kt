package ru.ptsecurity.navigation_example.ui.writetofile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentWriteToFileBinding

open class WriteToFileFragment : Fragment(R.layout.fragment_write_to_file) {

    companion object {
        private const val FILE_OUTPUT = "ptssecurity"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: WriteToFileFragmentArgs by navArgs()
        if (safeArgs.data.isNotEmpty()){
            requireContext().openFileOutput(FILE_OUTPUT, Context.MODE_PRIVATE)
                .use {
                    it.write(safeArgs.data.toByteArray())
                }
        }
    }
}