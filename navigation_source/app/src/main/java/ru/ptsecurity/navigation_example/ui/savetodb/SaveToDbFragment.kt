package ru.ptsecurity.navigation_example.ui.savetodb

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.data.DBHelper
import ru.ptsecurity.navigation_example.databinding.FragmentSaveToDbBinding

open class SaveToDbFragment : Fragment(R.layout.fragment_save_to_db) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: SaveToDbFragmentArgs by navArgs()
        if (safeArgs.name.isNotEmpty() && safeArgs.surname.isNotEmpty()){
            DBHelper(requireContext()).saveUserData(safeArgs.name, safeArgs.surname)
        }
    }
}