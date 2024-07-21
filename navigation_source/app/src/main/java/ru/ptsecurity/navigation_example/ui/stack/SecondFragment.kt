package ru.ptsecurity.navigation_example.ui.stack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val safeArgs: SecondFragmentArgs by navArgs()
        val view = inflater.inflate(R.layout.fragment_second,null)
        view.findViewById<Button>(R.id.buttonToFirst)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.toFirst, null)
        )

        if (safeArgs.textSecond.isNotEmpty()){
            view.findViewById<TextView>(R.id.text_second).setText(safeArgs.textSecond)
        }

        return view
    }
}