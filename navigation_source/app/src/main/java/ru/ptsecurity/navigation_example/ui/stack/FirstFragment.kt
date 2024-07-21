package ru.ptsecurity.navigation_example.ui.stack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import android.widget.Button
import android.widget.TextView
import ru.ptsecurity.navigation_example.R

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val safeArgs: FirstFragmentArgs by navArgs()
        val view = inflater.inflate(R.layout.fragment_first,null)
        view.findViewById<Button>(R.id.buttonToSecond)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.toSecond, null)
        )

        if (safeArgs.textFirst.isNotEmpty()){
            view.findViewById<TextView>(R.id.text_first).text = safeArgs.textFirst
        }

        return view
    }
}